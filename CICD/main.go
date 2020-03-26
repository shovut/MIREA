package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"runtime"
)

var (
	Url string = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party"
	ContentType string = "application/json"
	Accept string = "application/json"
	Authorization string = "Token ac2f008b4e05b77df92e7867279ec65239db4026"
// 7702726396
)

type InnRequest struct {
	Inn string `json:"inn"`
}

type InnResponse struct {
	Address string `json:"address"`
}

type DaDataRequest struct {
	Query string `json:"query"`
}


type DaDataResponse struct {
	Suggestions []struct {
		Data struct {
			Address struct {
				Value string `json:"value"`
			} `json:"address"`
		} `json:"data"`
	} `json:"suggestions"`
}

type ErrorMessage struct {
	Message string `json:"message"`
}

func main() {
	log.Println("Server is running")
	runtime.GOMAXPROCS(10)
	http.HandleFunc("/mandron",  hello)
	http.HandleFunc("/mandron/post", getInn)
	http.ListenAndServe(":8080", nil)

}

func getInn(writer http.ResponseWriter, request *http.Request) {
	switch request.Method {
	case "POST":
		log.Println("request routine start, num", runtime.NumGoroutine())
		var inn InnRequest
		writer.Header().Set("Content-Type", "application/json; charset=UTF-8")

		err := json.NewDecoder(request.Body).Decode(&inn)
		if err != nil {
			json.NewEncoder(writer).Encode(ErrorMessage{Message:"Incorrect JSON"})
			return
		}

		var in chan *DaDataRequest = make(chan *DaDataRequest)
		var ou chan *DaDataResponse = make(chan *DaDataResponse)

		go thread(in, ou)

		in <- &DaDataRequest{Query:inn.Inn}
		log.Println("request routine continue, num", runtime.NumGoroutine())
		res := <- ou
		if res == nil {
			json.NewEncoder(writer).Encode(ErrorMessage{Message:"Incorrect INN"})
			return
		}

		//log.Println(res)

		json.NewEncoder(writer).Encode(InnResponse{Address:res.Suggestions[0].Data.Address.Value})
		//json.NewEncoder(writer).Encode(inn)
		log.Println("request routine end, num", runtime.NumGoroutine())
		fmt.Println()


	default:
		fmt.Fprintf(writer, "Sorry, only POST method are supported.")
	}
}

func thread(in chan *DaDataRequest, ou chan *DaDataResponse) {
	log.Println("dadata routine start, num", runtime.NumGoroutine())
	req := <- in
	res, err := req.requestToDaData()
	if err != nil {
		log.Println("Err in thread")
	}
	ou <- res
	log.Println("dadata routine end, num", runtime.NumGoroutine())
}


func (req *DaDataRequest) requestToDaData() (*DaDataResponse, error) {

	res := new(DaDataResponse)
	body, err := json.Marshal(req)
	//log.Println(err)
	request, err := http.NewRequest(http.MethodPost, Url, bytes.NewReader(body))
	if err != nil {
		return nil, err
	}

	request.Header.Set("Content-Type", ContentType)
	request.Header.Set("Accept", Accept)
	request.Header.Set("Authorization", Authorization)

	//log.Println(err)
	client := &http.Client{}
	response, err := client.Do(request)
	if err != nil {
		return nil, err
	}
	body, err = ioutil.ReadAll(response.Body)
	if err != nil {
		return nil, err
	}
	//log.Println(string(body))
	//log.Println(err)
	json.Unmarshal(body, res)
	//log.Println(res)
	return res, nil
}

func hello (w http.ResponseWriter, r *http.Request) {
	//log.Println("hello")
	fmt.Fprintf(w, "Welcome to inn service!")
}
