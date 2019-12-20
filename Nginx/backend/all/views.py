from django.http import HttpResponse, JsonResponse, HttpRequest
from django.shortcuts import render
from all.data import Data

# Create your views here.


class Resp:

    js = Data.js.copy()

    @classmethod
    def getall(cls, request):
        print(cls.js)
        return JsonResponse(cls.js, safe=False)

    @classmethod
    def removebyid(cls, request):

        ids = list(request.GET['ids'].split(','))
        for i in range(len(ids)):
            for obj in cls.js:
                if obj['id'] in ids:
                    cls.js.remove(obj)
        print(cls.js)

    @classmethod
    def hello(cls, request):
        return HttpResponse("hello")


