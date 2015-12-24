/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.util.Locale;
import org.cogroo.analyzer.AnalyzerI;
import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.text.Document;
import org.cogroo.text.Sentence;
import org.cogroo.text.Token;
import org.cogroo.text.impl.DocumentImpl;

/**
 *
 * @author Arthur
 */
public class PostTaggerUtils {

    private static PostTaggerUtils INSTANCIA;
    private final ComponentFactory factory = ComponentFactory.create(new Locale("pt", "BR"));
    private final AnalyzerI cogroo = factory.createPipe();
    private final Document document = new DocumentImpl();

    public static PostTaggerUtils getINSTANCIA() {
        if (INSTANCIA == null) {
            INSTANCIA = new PostTaggerUtils();
        }
        return INSTANCIA;
    }

    public boolean temAdjetivo(String texto) {
        document.setText(texto.toLowerCase());
        cogroo.analyze(document);
        for (Sentence sentence : document.getSentences()) {
            for (Token token : sentence.getTokens()) {
                if (token.getPOSTag().equals("adj")) {
                    return true;
                }
            }
        }
        return false;
    }

}
