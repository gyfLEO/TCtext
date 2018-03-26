class Singleton {
    //将构造方法实例化
    private Singleton(){};

    //静态对象
    private static Singleton singleton = new Singleton();

    //
    public static Singleton getInstance(){
        return singleton;
    }


}
