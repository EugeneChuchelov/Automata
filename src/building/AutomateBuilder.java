package building;

import entity.Automate;
import entity.Function;
import entity.Grammar;
import entity.Rule;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AutomateBuilder {
    public static Automate build(Grammar grammar){
        Automate automate = new Automate();

        automate.setStates(Collections.singletonList('q'));
        automate.setStartState('q');
        automate.setTerminalAlphabet(grammar.getTerminal());

        List<Character> alphabet = new LinkedList<>();
        alphabet.addAll(grammar.getTerminal());
        alphabet.addAll(grammar.getNotTerminal());
        automate.setAlphabet(alphabet);

        automate.setStartSymbol(grammar.getStartSymbol());
        automate.setFinalStates(new LinkedList<>());

        automate.setFunctions(createFunctions(grammar));

        return automate;
    }

    private static List<Function> createFunctions(Grammar grammar){
        List<Function> functions = new LinkedList<>();
        functions.addAll(createFunctionsForRules(grammar));
        functions.addAll(createFunctionsForTerminal(grammar));
        return functions;
    }

    private static List<Function> createFunctionsForRules(Grammar grammar){
        List<Function> functions = new LinkedList<>();
        for(Rule rule : grammar.getRules()){
            Function function = new Function();
            function.setFromState('q');
            function.setFromSymbols(rule.getFrom());
            function.setToState('q');
            function.setToSymbols(rule.getTo());
            functions.add(function);
        }
        return functions;
    }

    private static List<Function> createFunctionsForTerminal(Grammar grammar){
        List<Function> functions = new LinkedList<>();
        for(Character character : grammar.getTerminal()){
            Function function = new Function();
            function.setFromState('q');
            function.setFromSymbols(Collections.singletonList(character));
            function.setInputSymbol(character);
            function.setToState('q');
            functions.add(function);
        }
        return functions;
    }
}
