import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText incomeInput, expenseInput;
    private Button addIncomeButton, addExpenseButton;
    private FinanceDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeInput = findViewById(R.id.incomeInput);
        expenseInput = findViewById(R.id.expenseInput);
        addIncomeButton = findViewById(R.id.addIncomeButton);
        addExpenseButton = findViewById(R.id.addExpenseButton);

        dbHelper = new FinanceDBHelper(this);

        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String income = incomeInput.getText().toString();
                if (!income.isEmpty()) {
                    dbHelper.addTransaction("Income", Double.parseDouble(income));
                    Toast.makeText(MainActivity.this, "Income Added", Toast.LENGTH_SHORT).show();
                    incomeInput.setText("");
                }
            }
        });

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expense = expenseInput.getText().toString();
                if (!expense.isEmpty()) {
                    dbHelper.addTransaction("Expense", Double.parseDouble(expense));
                    Toast.makeText(MainActivity.this, "Expense Added", Toast.LENGTH_SHORT).show();
                    expenseInput.setText("");
                }
            }
        });
    }
}
