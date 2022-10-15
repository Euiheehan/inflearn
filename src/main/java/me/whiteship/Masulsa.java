package me.whiteship;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {
    public static void main(String[] args) {
        ClassLoader classLoader = Masulsa.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);
        try {
            new ByteBuddy().redefine(typePool.describe("me.whiteship.Moja").resolve()
                            , ClassFileLocator.ForClassLoader.of(classLoader))
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit"))
                    .make().saveIn(new File("C:/Users/PC/Git/java8/target/classes/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //설정이 점점 많아지면 다른데에서 모자 클래스가 먼저 읽힐 수 있는 가능성 있기 때문에 완벽하진 않다.
        System.out.println(new Moja().pullOut());
    }
}

