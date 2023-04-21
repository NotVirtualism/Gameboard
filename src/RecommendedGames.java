import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class RecommendedGames {
    ArrayList<ArrayList<String>> games = new ArrayList<>();

    private ArrayList<String> allTags = new ArrayList<>();

    private ArrayList<String> favoriteTags = new ArrayList<>();

    static GameCollection recGames = new GameCollection("Recommended Games");


    public RecommendedGames(UserProfile user) throws IOException {

        GameDatabase allGames = new GameDatabase("bgg90games.xml");

        if (user.getSignInStatus()) {
            GameCollection allUserGames = user.getLibrary().getGameCollectionByIndex(0);
            int count;
            TagListComparator comp = new TagListComparator();
            for (int i = 0; i < allUserGames.size(); i++) {
                Game game = allUserGames.getGameByIndex(i);
                allTags.addAll(game.getTags());
            }
            for (String tag : allGames.getTags()) {
                count = Collections.frequency(allTags, tag);
                ArrayList<String> numberTags = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    numberTags.add(tag);
                }
                for (int i = 0; i < numberTags.size(); i++) {
                }
                if (numberTags.size() > 0) {
                    games.add(numberTags);
                }
            }
            for (int i = 0; i < 3; i++) {
                games.sort(comp);
                favoriteTags.add(games.get(i).get(0));
            }
            Search recGamesSearch = new Search("", favoriteTags, allGames.getMasterList());
            recGames = recGamesSearch.search();
        } else {
            recGames = allGames.getMasterList();
        }
    }

    public static GameCollectionView getRecommendView() {
        GameCollectionView recGameView = new GameCollectionView(recGames);
        return recGameView;
    }
}
