package ru.mirea.builderExample;

public class Cat {
    private String name;
    private String kind;
    private int age;
    private float weight;
    private String colors;

    @Override
    public String toString(){
        return "name " + name + "\n" +
                "kind " + kind + "\n" +
                "age " + age + "\n" +
                "weight " + weight + "\n" +
                "colors " + colors;
    }

    public static class Builder{
        private Cat newCat;

        public Builder() {
            newCat = new Cat();
        }

        public Builder withName(String name){
            newCat.name = name;
            return this;
        }

        public Builder withKind(String kind){
            newCat.kind = kind;
            return this;
        }

        public Builder withAge(int age){
            newCat.age = age;
            return this;
        }

        public Builder withWeight(float weight){
            newCat.weight = weight;
            return this;
        }


        public Builder withColors(String colors){
            newCat.colors = colors;
            return this;
        }

        public Cat build(){
            return newCat;
        }
    }
}
