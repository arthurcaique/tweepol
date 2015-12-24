/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unamed;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Fachada;
import tweet.Tweet;
import twitter4j.ExtendedMediaEntity;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Scopes;
import twitter4j.Status;
import twitter4j.SymbolEntity;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class RecuperarStatusJsonImpl1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File arq = ArquivoUtils.selecionarArquivo();
            ArrayList<Tweet> tweets = recuperarTweets(arq);
            File arq2 = ArquivoUtils.abrirFileChooserSalvarArquivo(".txt");
            Fachada.getINSTANCIA().inserirTweets(arq2, tweets);
        } catch (DadoInvalidoException | IOException | ErroInternoException | IndexOutOfBoundsException | ArquivoUtils.ArquivoNaoSalvoException ex) {
            Logger.getLogger(RecuperarStatusJsonImpl1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArquivoUtils.ArquivoNaoSelecionadoException ex) {
            Logger.getLogger(RecuperarStatusJsonImpl1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Tweet> recuperarTweets(File file) throws IOException, DadoInvalidoException {
        ArrayList<Tweet> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    try {
                        if (line.startsWith("StatusJSONImpl")) {
//                            if (line.contains("lang='pt'")) {
                            Teste t = new Teste().toString(line);
                            Teste t2 = new Teste().toString2(line);
//                            System.out.println(t.getId());
//                            System.out.println(t2.getId());
                            if (Objects.equals(t.getId(), t2.getId())) {
                                try {
                                    t.setText(t2.getText().replaceAll("'", ""));
                                    lista.add(new Tweet(t.getId(), t.getText(), t.isRetweet()));
//                                    System.out.println(t.getText());
                                    System.out.println(t.getCreatedAt());
                                } catch (NullPointerException e) {
                                    System.err.println(line);
                                }
                            }
//                            }
                        }
                    } catch (DadoInvalidoException ex) {
                        throw ex;
                    }
                }
            }
            System.out.println(lista.size());
            return lista;
        } catch (IOException e) {
            throw e;
        }
    }

    public static class Teste {

        private Date createdAt;
        private long id, inReplyToStatusId, inReplyToUserId, currentStatusRetweetId, quotedStatusId;
        private String text, source, inReplyToScreenName, lang;
        private boolean truncated, favorited, retweeted, retweet, retweetedByMe, possiblySensitive;
        private GeoLocation geoLocation;
        private Place place;
        private int favoriteCount, retweetCount, compareTo, accessLevel;
        private User user;
        private Status retweetedStatus, quotedStatus;
        private long[] contributors;
        private Scopes scope;
        private String[] withheldInCountries;
        private RateLimitStatus rateLimitStatus;
        private UserMentionEntity[] userMentionEntities;
        private URLEntity[] URLEntities;
        private HashtagEntity[] hashtagEntities;
        private MediaEntity[] mediaEntities;
        private ExtendedMediaEntity[] getExtendedMediaEntities;
        private SymbolEntity[] symbolEntities;

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getInReplyToStatusId() {
            return inReplyToStatusId;
        }

        public void setInReplyToStatusId(long inReplyToStatusId) {
            this.inReplyToStatusId = inReplyToStatusId;
        }

        public long getInReplyToUserId() {
            return inReplyToUserId;
        }

        public void setInReplyToUserId(long inReplyToUserId) {
            this.inReplyToUserId = inReplyToUserId;
        }

        public long getCurrentStatusRetweetId() {
            return currentStatusRetweetId;
        }

        public void setCurrentStatusRetweetId(long currentStatusRetweetId) {
            this.currentStatusRetweetId = currentStatusRetweetId;
        }

        public long getQuotedStatusId() {
            return quotedStatusId;
        }

        public void setQuotedStatusId(long quotedStatusId) {
            this.quotedStatusId = quotedStatusId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getInReplyToScreenName() {
            return inReplyToScreenName;
        }

        public void setInReplyToScreenName(String inReplyToScreenName) {
            this.inReplyToScreenName = inReplyToScreenName;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public boolean isRetweeted() {
            return retweeted;
        }

        public void setRetweeted(boolean retweeted) {
            this.retweeted = retweeted;
        }

        public boolean isRetweet() {
            return retweet;
        }

        public void setRetweet(boolean retweet) {
            this.retweet = retweet;
        }

        public boolean isRetweetedByMe() {
            return retweetedByMe;
        }

        public void setRetweetedByMe(boolean retweetedByMe) {
            this.retweetedByMe = retweetedByMe;
        }

        public boolean isPossiblySensitive() {
            return possiblySensitive;
        }

        public void setPossiblySensitive(boolean possiblySensitive) {
            this.possiblySensitive = possiblySensitive;
        }

        public GeoLocation getGeoLocation() {
            return geoLocation;
        }

        public void setGeoLocation(GeoLocation geoLocation) {
            this.geoLocation = geoLocation;
        }

        public Place getPlace() {
            return place;
        }

        public void setPlace(Place place) {
            this.place = place;
        }

        public int getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(int favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public int getRetweetCount() {
            return retweetCount;
        }

        public void setRetweetCount(int retweetCount) {
            this.retweetCount = retweetCount;
        }

        public int getCompareTo() {
            return compareTo;
        }

        public void setCompareTo(int compareTo) {
            this.compareTo = compareTo;
        }

        public int getAccessLevel() {
            return accessLevel;
        }

        public void setAccessLevel(int accessLevel) {
            this.accessLevel = accessLevel;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Status getRetweetedStatus() {
            return retweetedStatus;
        }

        public void setRetweetedStatus(Status retweetedStatus) {
            this.retweetedStatus = retweetedStatus;
        }

        public Status getQuotedStatus() {
            return quotedStatus;
        }

        public void setQuotedStatus(Status quotedStatus) {
            this.quotedStatus = quotedStatus;
        }

        public long[] getContributors() {
            return contributors;
        }

        public void setContributors(long[] contributors) {
            this.contributors = contributors;
        }

        public Scopes getScope() {
            return scope;
        }

        public void setScope(Scopes scope) {
            this.scope = scope;
        }

        public String[] getWithheldInCountries() {
            return withheldInCountries;
        }

        public void setWithheldInCountries(String[] withheldInCountries) {
            this.withheldInCountries = withheldInCountries;
        }

        public RateLimitStatus getRateLimitStatus() {
            return rateLimitStatus;
        }

        public void setRateLimitStatus(RateLimitStatus rateLimitStatus) {
            this.rateLimitStatus = rateLimitStatus;
        }

        public UserMentionEntity[] getUserMentionEntities() {
            return userMentionEntities;
        }

        public void setUserMentionEntities(UserMentionEntity[] userMentionEntities) {
            this.userMentionEntities = userMentionEntities;
        }

        public URLEntity[] getURLEntities() {
            return URLEntities;
        }

        public void setURLEntities(URLEntity[] URLEntities) {
            this.URLEntities = URLEntities;
        }

        public HashtagEntity[] getHashtagEntities() {
            return hashtagEntities;
        }

        public void setHashtagEntities(HashtagEntity[] hashtagEntities) {
            this.hashtagEntities = hashtagEntities;
        }

        public MediaEntity[] getMediaEntities() {
            return mediaEntities;
        }

        public void setMediaEntities(MediaEntity[] mediaEntities) {
            this.mediaEntities = mediaEntities;
        }

        public ExtendedMediaEntity[] getGetExtendedMediaEntities() {
            return getExtendedMediaEntities;
        }

        public void setGetExtendedMediaEntities(ExtendedMediaEntity[] getExtendedMediaEntities) {
            this.getExtendedMediaEntities = getExtendedMediaEntities;
        }

        public SymbolEntity[] getSymbolEntities() {
            return symbolEntities;
        }

        public void setSymbolEntities(SymbolEntity[] symbolEntities) {
            this.symbolEntities = symbolEntities;
        }

        @Override
        public String toString() {
            return "StatusJSONImpl{"
                    + "createdAt=" + createdAt
                    + ", id=" + id
                    + ", text='" + text + '\''
                    + ", source='" + source + '\''
                    + ", isTruncated=" + truncated
                    + ", inReplyToStatusId=" + inReplyToStatusId
                    + ", inReplyToUserId=" + inReplyToUserId
                    + ", isFavorited=" + favorited
                    + ", inReplyToScreenName='" + inReplyToScreenName + '\''
                    + ", geoLocation=" + geoLocation
                    + ", place=" + place
                    + ", retweetCount=" + retweetCount
                    + ", wasRetweetedByMe=" + retweetedByMe
                    + ", contributors=" + (contributors == null ? null : Arrays.asList(contributors))
                    + ", retweetedStatus=" + retweetedStatus
                    + ", userMentionEntities=" + (userMentionEntities == null ? null : Arrays.asList(userMentionEntities))
                    + ", urlEntities=" + (URLEntities == null ? null : Arrays.asList(URLEntities))
                    + ", hashtagEntities=" + (hashtagEntities == null ? null : Arrays.asList(hashtagEntities))
                    + ", user=" + user
                    + '}';
        }

        public Teste toString(String string) throws DadoInvalidoException {
            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                    Locale.US);
            string = string.replaceAll("StatusJSONImpl", "");
            string = string.replaceAll("\\{", "");
            string = string.replaceAll("\\}", "");
            String[] a = string.split(", ");
            for (String var : a) {
                if (var.contains("createdAt=") && !var.contains("mediaEntities") && !var.contains("user")
                        && !var.contains("expandedURL") && !var.contains("retweetedStatus") && this.createdAt == null) {
                    String b = "";
                    try {
                        b = var.replace("createdAt=", "");
                        this.createdAt = sdf.parse(b);
                    } catch (ParseException ex) {
                        System.out.println(b);
                        throw new DadoInvalidoException("Data errada!");
                    }
                }
                if (var.contains("id=")
                        && !var.contains("mediaEntities")
                        && !var.contains("user")
                        && !var.contains("expandedURL")
                        && !var.contains("url")
                        && var.replaceAll("id=", "").replaceAll("\\d", "").isEmpty()
                        && this.id == 0) {
                    String b = var.replace("id=", "");
                    try {
                        this.id = Long.valueOf(b);
                    } catch (NumberFormatException e) {
                        System.err.println(b);
                    }
                }
                if (var.contains("text=") && text == null) {
                    String b = var.replace("text=", "");
                    this.text = b;
                }
                if (var.contains("retweetedStatus=") && !this.retweet) {
                    String b = var.replace("retweetedStatus=", "");
                    if (!b.equalsIgnoreCase("null")) {
                        this.retweet = true;
                    }
                }
            }
            return this;
        }

        public Teste toString2(String string) throws DadoInvalidoException {
            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                    Locale.US);
            string = string.replaceAll("StatusJSONImpl", "");
            string = string.replaceAll("\\{", "");
            string = string.replaceAll("\\}", "");
            String[] a = string.split(", source");
            for (String var : a) {
                var = var.concat(", source");
                if (!var.contains("href")) {
                    if (var.contains("createdAt=") && !var.contains(", mediaEntities") && !var.contains(", user")
                            && !var.contains(", expandedURL") && !var.contains(", retweetedStatus")
                            && this.createdAt == null) {
                        String b = "";
                        try {
                            b = var.split(", id=")[0].replaceAll("createdAt=", "");
                            this.createdAt = sdf.parse(b);
                        } catch (ParseException ex) {
                            System.out.println(b);
                            throw new DadoInvalidoException("Data errada!");
                        }
                    }
                    if (var.contains(", text")
                            && !var.contains("mediaEntities")
                            && !var.contains("user")
                            && !var.contains("expandedURL")
                            && !var.contains("url")
                            && this.id == 0) {
                        String b = var.substring(var.indexOf("BRT 2015, id="), var.indexOf(", text=")).replaceAll("BRT 2015, id=", "");
                        try {
                            this.id = Long.valueOf(b);
                        } catch (NumberFormatException e) {
                            System.err.println(b);
                        }
                    }
                    if (var.contains(", source") && this.text == null) {
                        String b = var.substring(var.indexOf("text="), var.indexOf(", source")).replaceAll("text=", "");
                        this.text = b;
                    }
                }
            }
            return this;
        }
    }
}
