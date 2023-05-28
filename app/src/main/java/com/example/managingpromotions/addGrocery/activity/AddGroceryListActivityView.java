package com.example.managingpromotions.addGrocery.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.addGrocery.presenter.AddGroceryPresenterImpl;
import com.example.managingpromotions.model.GroceryListDTO;
import com.example.managingpromotions.model.GroceryListProductDTO;
import com.example.managingpromotions.clientHttp.GroceryListAPI;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddGroceryListActivityView extends AppCompatActivity {

    private final List<GroceryListProductDTO> productDTOS = new ArrayList<>();

    private TextInputEditText inputNameProduct, inputAmount, inputGroceryListName;
    private GroceryListProductsAdapter groceryListProductsAdapter;
    private RecyclerView recyclerView;
    private Button addGroceryRowButton, saveGroceryListButton;
    private AddGroceryPresenterImpl addGroceryPresenter;

    private GroceryListAPI groceryListAPI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_grocery_list_form);
        initComponents();
        initPresenter();

        groceryListProductsAdapter = new GroceryListProductsAdapter(productDTOS, this);
        recyclerView.setAdapter(groceryListProductsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        addGroceryRowButton.setOnClickListener(view -> {

            GroceryListProductDTO groceryListProductDTO = new GroceryListProductDTO();
            groceryListProductDTO.setName(Objects.requireNonNull(inputNameProduct.getText()).toString());
            groceryListProductDTO.setAmount(Integer.valueOf(Objects.requireNonNull(inputAmount.getText()).toString()));

            productDTOS.add(groceryListProductDTO);

            groceryListProductsAdapter.notifyItemChanged(productDTOS.size() - 1);
        });

        saveGroceryListButton.setOnClickListener(view -> {
            //todo validation

            GroceryListDTO groceryListDTO = buildGroceryListDTO();

            addGroceryPresenter.saveGroceryList(groceryListDTO);
        });
    }

    private void initComponents() {
        recyclerView = findViewById(R.id.fragment_grocery_list_rv);
        inputNameProduct = findViewById(R.id.input_name_product);
        inputAmount = findViewById(R.id.input_amount);
        addGroceryRowButton = findViewById(R.id.add_product_button);
        saveGroceryListButton = findViewById(R.id.saveGroceryButton);
        inputGroceryListName = findViewById(R.id.input_grocery_list_name);
    }

    private void initPresenter() {
        this.addGroceryPresenter = new AddGroceryPresenterImpl(this);
    }

    private GroceryListDTO buildGroceryListDTO() {
        GroceryListDTO groceryListDTO = new GroceryListDTO();

        groceryListDTO.setName(Objects.requireNonNull(inputGroceryListName.getText()).toString());
        groceryListDTO.setProducts(productDTOS);

        return groceryListDTO;
    }

    public void displayMessage(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
    }
}
