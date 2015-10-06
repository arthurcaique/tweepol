/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capturador;

import capturador.repositorio.RepositorioStatus;
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
import utilitarios.exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public class CapturadorTweets {

    private static CapturadorTweets instancia;

    public static CapturadorTweets getInstancia(File arquivo, String... filtros) {
        if (instancia == null) {
            instancia = new CapturadorTweets(arquivo, filtros) {
            };
        }
        return instancia;
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
                    CapturadorTweets.getInstancia(arquivo, filtros);
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
