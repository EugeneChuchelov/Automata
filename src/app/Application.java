package app;

import building.AutomateBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Automate;
import entity.Grammar;
import check.type.Type;
import resolve.Resolve;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static check.type.Check.check;
import static ui.GrammarInput.input;

public class Application {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "IBM437");

        Grammar gr = null;

        if(args.length > 0){
            if(args[0].equals("-l")){
                gr = loadGrammar(args[1]);
            }
            if(args[0].equals("-s")){
                gr = input();
                saveGrammar(args[1], gr);
            }
            if(args[0].equals("-h")){
                System.out.println(help());
                System.exit(0);
            }
        } else {
            try{
                gr = input();
            } catch (Exception e){
                System.out.println("Ошибка ввода");
                System.exit(-1);
            }

        }

        Type type = null;
        try {
             type = check(gr);
        } catch (Exception e){
            System.out.println("Ошибка проверки");
            System.exit(-1);
        }

        Automate automate = null;
        if(type == Type.ContextFree || type == Type.Regular){
            automate = AutomateBuilder.build(gr);
        } else {
            System.out.println("Граматика должна быть контекстно-свободной");
            System.exit(-1);
        }

        List<Character> input = new LinkedList<>();
        String string = "(a)";
        for(Character c : string.toCharArray()){
            input.add(c);
        }
        Resolve.resolve(automate, input);
    }

    private static String help(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("To load from file: ")
                .append("-l grammarFile.json")
                .append("\n")
                .append("To enter from console and save to file: ")
                .append("-s file.json");
        return stringBuilder.toString();
    }

    private static void saveGrammar(String filepath, Grammar gr) {
        try(FileWriter w = new FileWriter(filepath)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(gr, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Grammar loadGrammar(String filepath) {
        Grammar grammar = null;
        try (FileReader r = new FileReader(filepath)) {
            Gson gson = new GsonBuilder().create();
            grammar = gson.fromJson(r, Grammar.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grammar;
    }
}
