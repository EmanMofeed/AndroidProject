package com.example.androidstudioproject;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import android.widget.TextView;
import com.example.androidstudioproject.model.anime;
import java.util.ArrayList;

public class CartRecyclerViewAdapterTest {

@Test
public void testCalculateTotalPriceForAllCart() {
    ArrayList<anime> cartAnime = new ArrayList<>();

    anime anime1 = new anime();
    anime1.setQuantity(2);
    anime1.setPrice(10);
    cartAnime.add(anime1);

    anime anime2 = new anime();
    anime2.setQuantity(3);
    anime2.setPrice(20);
    cartAnime.add(anime2);

    TextView totalTextView = new TextView(null);
    TextView totalAfterFeeTextView = new TextView(null);

    cartRecyclerViewAdapter adapter = new cartRecyclerViewAdapter(cartAnime, totalTextView, totalAfterFeeTextView);

    double expected = 80;
    double actual = adapter.calculateTotalPriceForAllCart();

    assertEquals(expected, actual, 0.001);
}

}
