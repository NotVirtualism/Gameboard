import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ReviewView {

    /**
     * Constructs a review view from a User Profile u.
     * @param u a user.
     */
    public ReviewView(UserProfile u)
    {
        reviewView(u);
    }

    /**
     * Displays the User's review information on the screen.
     * @param u the logged in User.
     * @return a panel to be used in HomeView.
     */
    public static JPanel reviewView(UserProfile u)
    {
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        ArrayList<Review> yourReviews = new ArrayList();
        yourReviews = u.getReviews();

        String yourReviewsHolder = "<html>";
        for (int counter = 0; counter < yourReviews.size(); counter++) {
            if (counter == 0)
            {
                yourReviewsHolder = yourReviewsHolder + yourReviews.get(counter).toString();
            }
            yourReviewsHolder = yourReviewsHolder + "<br/>" + yourReviews.get(counter).toString();
        }



        JLabel label = new JLabel(yourReviewsHolder);
        label.setBorder(new LineBorder(Color.black));
        panel.add(label, c);
        scrollPane.getViewport().setPreferredSize(new Dimension(400, 400));
        JPanel contentPane = new JPanel();
        contentPane.add(scrollPane);



        return contentPane;
    }

}
