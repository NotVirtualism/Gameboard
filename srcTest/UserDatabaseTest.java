public class UserDatabaseTest {
    public static void main(String[] args) {

        System.out.println(UserDatabase.getAllUsers().size() + " Users read in.");
        System.out.println("User List: \n");
        for(UserProfile user : UserDatabase.getAllUsers()) {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(user.getReviews().size() + " Reviews");
            for (Review review : user.getReviews()) {
                System.out.println(review.getGameName());
                System.out.println(review.getScore());
                System.out.println(review.getText());
            }
            for(GameCollection collection : user.getLibrary().getCollections()){
                System.out.println(collection.getName());
                for(Game game: collection.list){
                    System.out.println(game.getTitle());
                    System.out.println(game.getReviews().get(0).getText());
                }
            }

        }
    }
}