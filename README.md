# hello-world
just another repository



----HelloWorld.java------ import java.util.*; 
 
public class HelloWorld { String str; Public void hello() {     str = ―Hello World!‖; } Public String getStr() {     Return str; } } -----HelloWorldTest.java---------- import static org.junit.Assert.*; import org.junit.Test; 
 
public class HelloWorldTest { public HelloWorld helloworld = new HelloWorld(); @Test Public void testHello() {     helloworld.hello();     assertEquals(―Hello World!‖, helloworld.getStr()); } } 把这两个文件放在同一个目录下。 使用如下命令运行： @sser>javac –classpath .:junit-4.9.jar HelloWorldTest.java @sser>java –classpath .:junit-4.9.jar –ea org.junit.runner.JUnitCore HelloWorldTest 可得到如下输出结果： JUnit version 4.9 . Time 0.007 OK(1 test) 我们可以看到运行正确，这也证明了我们的环境配置正确。 
