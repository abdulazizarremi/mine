package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whppedCreamCheckBox = findViewById(R.id.Whipped_cream_checkbox);
        boolean hasWhippedCream = whppedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.Chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        int price = calculatePrice(hasChocolate, hasWhippedCream);
        String priceMessage = creatOrderSummary (name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean addChocolate, boolean addWhippedCream) {

        int basePrice = 10;

        if (addChocolate) {
            basePrice = basePrice + 3;
        }
        if (addWhippedCream) {
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    private String creatOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " +name;
        priceMessage += "\nAdd whipped Cream? " +addWhippedCream;
        priceMessage += "\nAdd Chocolate? " +addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal price SR" + calculatePrice();
        priceMessage += "\nThank you!";
        return priceMessage;
    }



    public void increment(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayTotal(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
