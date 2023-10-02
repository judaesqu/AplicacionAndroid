package com.example.presupuestos;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etInitialValue;
    private EditText etProductName;
    private EditText etProductPrice;

    private Button btnAddProduct;
    private ListView listViewProducts;
    private TextView tvCurrentValue;
    private double currentValue = 0.0;
    private TextView tvCurrentSaldo;

    private double currentSaldo = 0.0;

    private double initialValue = 0.0;

    private ArrayList<Producto> productos;
    private ArrayAdapter<Producto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInitialValue = findViewById(R.id.etInitialValue);
        etProductName = findViewById(R.id.etProductName);
        etProductPrice = findViewById(R.id.etProductPrice);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        listViewProducts = findViewById(R.id.listViewProducts);
        tvCurrentValue = findViewById(R.id.tvCurrentValue);
        tvCurrentSaldo = findViewById(R.id.tvCurrentSaldo);


        productos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productos);
        listViewProducts.setAdapter(adapter);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });
    }

    private void addProduct() {
        String productName = etProductName.getText().toString();
        String productPriceStr = etProductPrice.getText().toString();
        String initialValueStr = etInitialValue.getText().toString();



        if (!productName.isEmpty() && !productPriceStr.isEmpty()) {
            double productPrice = Double.parseDouble(productPriceStr);
            double initialValue = Double.parseDouble(initialValueStr);
            Producto producto = new Producto(productName, productPrice);

            // Agrega el producto a la lista
            productos.add(producto);
            adapter.notifyDataSetChanged();

            // Actualiza el valor actual (suma el precio del producto)
            currentValue += productPrice;
            tvCurrentValue.setText("Subtotal: $" + currentValue );

            //Actualiza el valor actual (resta el valor del precio al valor inicial)
            currentSaldo =  initialValue-currentValue;
            tvCurrentSaldo.setText("Saldo: $"+ currentSaldo);


            // Limpia los campos
            etProductName.setText("");
            etProductPrice.setText("");
        }
    }
}