/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura;

import captura.repositorio.RepositorioStatus;
import fabricas.FabricaTwitterStream;
import java.io.File;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.json.DataObjectFactory;
import exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public class CapturadorTweets {

    private static CapturadorTweets INSTANCIA;

    public static CapturadorTweets getINSTANCIA(File arquivo, String... filtros) {
        if (INSTANCIA == null) {
            INSTANCIA = new CapturadorTweets(arquivo, filtros) {
            };
        }
        return INSTANCIA;
    }

    public CapturadorTweets(File arquivo, String... filtros) {
        try {
            StatusListener listener = new StatusAdapter() {
                @Override
                public void onStatus(Status status) {
                    try {
                        String statusJson = DataObjectFactory.getRawJSON(status);
                        JSONObject JSON_complete = new JSONObject(statusJson);
                        RepositorioStatus.getINSTANCIA().inserirStatus(arquivo, JSON_complete);
                    } catch (JSONException ex) {
                        System.err.println(ex.getCause());
                    } catch (ErroInternoException ex) {
                        System.err.println(ex.getMessage());
                    }
                }

                @Override
                public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                }

                @Override
                public void onException(Exception ex) {
                    CapturadorTweets.getINSTANCIA(arquivo, filtros);
                }

            };
            TwitterStream twitterStream = FabricaTwitterStream.getInstancia().getTwitterStream();
            twitterStream.addListener(listener);
            twitterStream.filter(filtros);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
