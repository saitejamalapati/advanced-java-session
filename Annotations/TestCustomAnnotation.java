import java.lang.annotation.*; 
import java.lang.reflect.*; 
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD)
@interface MyAnnotation { 
   int annotationMethod(); 
} 
//Applying annotation 
class Hello{ 
   @MyAnnotation(annotationMethod=10)
   public void sayHello(){
       System.out.println("hello annotation");
   } 

   @MyAnnotation(annotationMethod=25)
   public void sample() {
       System.out.println("Sample Method");
   }
} 

//Accessing annotation 
public class TestCustomAnnotation { 
   public static void main(String args[])throws Exception { 
       Hello h = new Hello(); 
       Method m1 = h.getClass().getMethod("sayHello"); 
       Method m2 = h.getClass().getMethod("sample");
       MyAnnotation manno1 = m1.getAnnotation(MyAnnotation.class); 
       MyAnnotation manno2 = m2.getAnnotation(MyAnnotation.class);
       System.out.println("value of MyAnnotation in sayHello is: "+manno1.annotationMethod());  
       System.out.println("value of MyAnnotation in sample is: "+manno2.annotationMethod()); 
   }
}
