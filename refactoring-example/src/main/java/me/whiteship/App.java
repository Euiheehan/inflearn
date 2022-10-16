package me.whiteship;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {
        //클래스 접근하는 방법1
        //Class<Book> bookClass = Book.class;

        //클래스 접근하는 방법2
        //Book book = new Book();
        //Class<? extends Book> aClass = book.getClass();

        //클래스 접근하는 방법3
        //Class<?> aClass1 = Class.forName("me.whiteship.Book");


        Class<Book> bookClass = Book.class;

        //public 한것만 가져옴
        //Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        //접근제어자 상관없이 다 가져옴
        //Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        Book book = new Book();
        /*Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            try {
                //(2)접근허용 해줘야함
                field.setAccessible(true);

                //(1)이 코드만 하면 Error 접근 불가로
                System.out.printf("%s %s\n", field, field.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });*/


        //Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        //Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);


        /*Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);*/

        //Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        Arrays.stream(Book.class.getDeclaredFields()).forEach(field -> {
            int modifiers = field.getModifiers();
            System.out.println(field);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
            field.getDeclaredAnnotations();
        });

    }
}
