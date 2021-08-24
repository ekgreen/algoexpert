package com.goodboy.algorithms.easy;

import com.github.junrar.Junrar;
import lombok.SneakyThrows;
import org.paukov.combinatorics3.Generator;

import java.io.File;
import java.util.List;

public class RarOpen {

    @SneakyThrows
    public static void main(String[] args) {
        final File rar = new File("D:\\vm\\архив.rar");
        final File dest = new File("D:\\vm\\test");


        Generator.combination("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
                .multi(6)
                .stream()
                .map(list -> String.join("", list))
                .forEach(pwd -> {
                    try {
                        List<File> extract = Junrar.extract(rar, dest, pwd);

                        if(extract.isEmpty()){
                            System.out.println("empty pwd = " + pwd);
                        }else {
                            System.out.println("pwd = " + pwd);
                            System.exit(100);
                        }
                    } catch (Exception ex) {
                        /**/
                    }
                });
    }


}
