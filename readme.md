#JDK8的函数式接口-Demo Cases

##有以下好几种类型:
##1.Function
    Function< T, R >	接收T对象，返回R对象

##2.Consumer
    Consumer< T >	接收T对象，不返回值

##3.Predicate
    Predicate< T >	接收T对象并返回boolean

##4.Supplier
    Supplier< T >	提供T对象（例如工厂），不接收值

##5.UnaryOperator
    UnaryOperator	接收T对象，返回T对象
    
##6.BinaryOperator
    BinaryOperator  接收两个T对象，返回T对象
