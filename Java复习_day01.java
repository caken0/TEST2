一.Java基础语法
  1.配置环境变量目的
      1.直接把java的安装路径写在path里面就OK
         为了在任意目录下都能运行配置在path路径下的exe程序
      2.先配置Java_Home,然后在把Java_Home写在path中
        Java_home=d:\jdk;
        path=%java_home%\bin;...
        tomcat需要这个参数
      3.java -version
        查看jdk版本以及jdk是32bit还是64bit
        eclipse要求:
          32Bit的Eclipse必须对应32Bit的JDK
          64Bit的Eclipse必须对应64Bit的JDK
          eclipse.ini中x86_64代表64bit
          eclipse.ini中x86代表32bit
       4.配置过环境变量
         mysql 配置目的为了使用mysql下的命令
         maven 为了使用一些maven命令:install,clean..
         subversion:版本控制工具
  2.常量分类
    1.基本类型常量
      整形常量: (数量)
          1 2 3 4 5 
          0b01 二进制
          03  八进制
          0x3CDE 十六进制(0~9,A~F)
      
      小数(浮点)常量 (金额) 
         1.3 3.2
      
      字符常量:用单引号括起来的单个字符 (性别)
        'a','你',
        //''//不允许有空字符
        '\''  如果输出特殊字符需要转义 \      
     
      布尔常量:只有两个值
        true false 

    2.引用类型常量
       a.字符串常量:用双引号括起来任意多个字符
        "abc",字符串是个引用类型,自身就是个对象
         ""//可以有而且本身也是个对象
       b.NULL常量:只能赋值给引用类型变量
        String str=null;//代表str不再指向任何对象
        String str="abc"//str指向abc的地址值
       c.把变量变成常量
         final int i=3;//final修饰的常量只能赋值一次
         final String str="def";//代表str中的内存地址值不能变
                              //恒指向一个对象永远不能改变str的指向
  
  3.变量分类(占用字节数,取值范围)

    整形变量:只要定义整数优先考虑int,整形常量默认是int
       byte        1byte    -128~127 //网络传输中都是字节 
       short(最不常用) 
       int        4byte     
       long       8byte //存毫秒值 365年=365*365*24*60*60*1000
                       //学生学号 2011989876534
                       //如果定义long类型常量末尾跟一个L
                     //long l=3L;
    小数变量
       float  4byte
       double 8byte
     float和double区别:
       1.double表示数据范围比float范围
       2.double表示的精度比float高
       3.java中默认小数类型double
        float f =3.0f;
    字符变量
       char 2byte
     
      char ch='男';//一个中文默认中文码表也是占用2个byte因此能用char存

    布尔变量
       boolean

      boolean b=true;
    字符串变量
      String
    
    类型转换:
       a.自动类型转换
         byte,short-->int-->long-->float-->double
         任选箭头方向两种都是自动类型提升
       b.强转
        byte,short<--int<--long<--float<--double
        强转后的类型 变量=(强转后的类型)原始变量
  4.运算符
   /,%,++,+=,||,&& 
    a./,% 
       求34的每位数字
       34 / 10=3
       34 % 10=4
    b.++:
      前置自增:先自增,后使用
      后置自增:先使用,后自增
       int a=3;
       int b=3;
       System.out.println(a++);
       System.out.println(++b);

       int m=1,n=1;
       int x=++m;
       System.out.println(m);//2
       System.out.println(x);//2
       
       int y=n++;
       System.out.println(y);//1
       System.out.println(n);//2
       
       int i=1;
       int z=i++ + 3;
       System.out.println(z);
       /*
        int i=1;
        int z=i++ + 3;
    
        * int m=i++;
        * int z= m+3;
        */
       System.out.println(z);
    
    c.||,&&
      ||:短路或,如果左边表达式为真,就不在运算表达式右边,整个表达式真
         如果购买的商品超过3件或者总金额大于1000 我就打折
         
         有真即为真,全假才为假

      &&:短路与(并且),如果左边表达式为假,就不在运算表达式右边,整个表达式假
         如果购买的商品超过3件并,并且总金额大于1000 我就打折
        
         有假即为假,全真才为真

  5.键盘录入,if,switch
    a.键盘录入
      引用类型用法:
        1.导包
        2.引用类型 引用变量名=new 引用类型()
        3.使用引用类型中的功能
      Scanner sann=new Scanner(System.in);//关联键盘
      int i=sann.nextInt();//录入整数
      scann.nextLine();//录入字符串
      scann.next();//录入字符串不能录空格
    b.if 三种结构
      1.单身狗
        if(布尔表达式){
           
        }
      2.一夫一妻
        if(布尔表达式){
           
        }else{

        }
      3.男女朋友
        if(布尔表达式){

        }else if(布尔表达式){

        }else if(布尔表达式){

        }else{

        }

        if(布尔表达式){

        }else{
            if (布尔表达式) {
              
            }else{


            }

        }
    c.switch:变量类型:byte,short,char,int,
                      1.5 enum 1.7 String
      switch(变量){
          case 常量: 语句;break;
          case 常量: 语句;break;
          case 常量: 语句;break;
          case 常量: 语句;break;
          default:语句;
      }
  6.循环结构:需要重复执行的语句
    a.while:
        while(布尔表达式){
          循环的语句;
          如果布尔表达式为真才执行循环体,直到布尔表达式为假跳出循环
        }
        
        int sum1=0;//统计偶数的和
        int sum2=0;//统计的奇数的和
        int i=1;
        while(i<=100){
          if (i%2==0) {
             sum1+=i;
          }else{
            sum2+=i;
          }
          i++;
        }
        System.out.println(i);//101
    b.for:
      for(定义变量;布尔表达式;步进表达式(自增/自减)){
          循环语句
      }
      int sum1=0;//统计偶数的和
      int sum2=0;//统计的奇数的和
      for(int i=1;i<=100;i++){
          if (i%2==0) {
             sum1+=i;
          }else{
            sum2+=i;
          }
      }
     // System.out.println(i);//for中的i仅能在循环中用,超出循环,i销毁
    c.双层for 
      ****
      ****
      ****
      for(int i=0;i<3;i++){//外层循环控制打印多少行
        
        for(int j=0;j<4;j++){//内层循环控制每行打印多少个
             System.out.print("*");
        }
          System.out.println();//每行打印完之后,末尾追加一个换行
      }
  7.break,continue
    a.break 
       一旦遇到break,立马跳出循环,如果是双层循环,break跳出离他最近的循环
      String[] str={"张三丰","慕容紫英","柳梦璃","李逍遥"}//查找柳梦璃,人名不重复

      boolean flag=findName(str,"柳梦璃");
      /*
        返回值:找到返回true,没找到返回false
        形参:
      */
      public boolean findName(String[] names,String keyword){
         boolean flag=false;
         for(String name : names){
            if(keyword.equals(name)){
                flag=true;
                break;//一旦找到立马终止查找
            }
         }
         return flag;
      }
     b.continue
       一旦遇到continue,结束本次循环开始下次循环
       int sum=0;
       for(int i=0;i<10;i++){
         if(i%2==0){//一旦i是偶数,立马跳过
           continue;
         }
         sum+=i;
       }

  8.一维数组(集合代替一维数组)& 二维数组(被嵌套集合代替)
       a.数组由来:声明很多同类型的变量比较繁琐,因此用数组代替
         int[] arr=new int[100];
       b.数组和集合:
         数组一旦定义需要考虑长度,而集合不用考虑长度
         数组一般用来存储同种类型,集合存多种类型
       c.数组定义:
         动态初始化:声明数组的时候事先指定长度,没有赋值
             int[] arr=new int[100];
         静态初始化:定义的时候赋值
             int[] arr={1,2,3}

         整数数组,元素默认值0
         小数数组,默认值0.0
         引用数组,默认值null
        d.JVM中内存划分
          栈:局部变量
          堆:放对象(数组)
          方法区:方法定义信息,静态变量
          常量池:常量
        e.数组中常见两个错误
          NullPointerExcetion
             int[] arr=null;
             System.out.println(arr.length);
          indexOutOfBonudsException
             int[] arr=new int[2];
             //System.out.println(arr[2]);

       一维数组求最值
          int[] arr={9,1,3,7,2}
          int max=arr[0];
          int min=arr[0];
          for(int i=1;i<arr.length;i++){
               if(arr[i]>max){
                 max=arr[i];
               }else if(arr[i]<min){
                 min=arr[i];
               }
          }
          System.out.println(max);
          System.out.println(min);
       
       二维数组(数组的数组)遍历
        int[][] arr={{3,4},{7,8}};

        for(int i=0;i<arr.length;i++){//遍历每个一维数组
                                      //arr.length代表一维数组的个数
           for(int j=0;j<arr[i].length;j++){//遍历每个一维数组中的元素
              System.out.println(arr[i][j]);
           }

        }
        
  9.经典小算法
    按照格式打印数组:
      int[] arr={3,4,5,6}
      最终打印格式 [3, 4, 5, 6]
  	
    冒泡排序:相邻的两个元素不断比较,大数下沉,小数上浮
       int[] arr={9,1,5,3};
        9 1 5 3
      第0轮   
          1 9 5 3  9>1交换
          1 5 9 3  9>5交换
          1 5 3 9  9>3交换  
                   此时第0轮结束,求出最大值 9
      第1轮
          1 5 3   1<5 不交换
          1 3 5   5>3 交换 
                  此时第1轮结束,求出次大值 5
      第2轮
          1 3   1<3 不交换
                  此时第2轮结束,求出倒数第三个值 3
    
    选择排序:每次拿未排序序列的起始位置元素与其它元素比较
      int[] arr={9,1,5,3}
      第0轮
         1 9 5 3    9>1交换
         1 9 5 3    1<5不交换
         1 9 5 3    1<3不交换 
                   此时第0轮结束,求出最小值 1
      第1轮
           5 9 3   9>5交换
           3 9 5   5>3交换
                  此时第1轮结束,求出1号索引的值3

      第2轮
          5 9  9>5交换  
                此时第2轮结束,求出2号索引的值5
  	二分查找(折半查找)
      要求查找的序列必须有序
      int[] arr={1,3,5,6,9},找3
      int min=0;
      int max=arr.length-1;
      int mid=(min+max)/2;

  10.方法
    a.方法由来:对于重复逻辑我们放在方法中,重复使用,简化代码
     public static void main(String[] args) {
         getArea(3,4);
         getArea(4,5);
         getArea(5,10);

     
     }
     public static int getArea(int width,int length){
      return width * length;
     }
    b.一般的方法的形参和返回值定义:
      对于经常变化的量我们考虑把变化的量定义方法的形参
      当方法中的逻辑有运算结果的时候,我们一般把它作为返回值 
    
    c.方法的重载:对于相似的功能我们利用重载
                 方法名必须相同,参数列表(参数个数不同或者参数类型不同或者参数的类型的顺序不同)必须不同
      public void method1(int a){

      }
      public void method1(int a,int b){

      }

      public void method2(int a){

      }
      public void method2(double a){

      }

      /*
      //同名方法
      public void method3(int a,int b){

      }
      public void method3(int b,int a){

      }*/
    d.基本类型与引用类型值传递
 
 11.断点调试
  /*
   断点:哪里要断(暂停)点哪里
   启动调试:右键debug run-->java application
   Variables视图:程序中已声明的变量显示在这个视图
   F5:向下执行一行,进入方法内部去看方法执行逻辑
   F6:不进入方法查看,但是方法执行完毕
   F7:把方法中的代码全部执行完,但是我们不想看执行过程,直接返回
   Expressions视图:可以利用当前已声明的变量自定义表达式
   F2:把显示当前变量值的窗口固定
   F8:跳断点,例如进入循环中不想把循环的过程看完,直接采用跳断点
      两个断点之间代码也被执行
   
  */
  a.进入方法内部
	b.不进入方法内部
	c.跳断点(循环跳出)
	d.查看变量
	e.删除所有断点,断点暂时失效
	f.添加表达式