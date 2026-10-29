package com.example.szachownica;
import static java.lang.Math.min;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Panel P;
    private Paint tlo_pola = new Paint();
    private Paint tlo_pola2 = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        tlo_pola.setColor(Color.WHITE);
        tlo_pola2.setColor(Color.BLACK);

        P = new Panel(this);
        setContentView(P);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_tworca) {
            Toast.makeText(getApplicationContext(),"Twórca: Kacper Siedlecki", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.menu_wyjscie) {
            finish();
            return true;
        }
        else if (id == R.id.kolor_czarno_biale) {
            tlo_pola.setColor(Color.WHITE);
            tlo_pola2.setColor(Color.BLACK);
            P.postInvalidate();
            return true;
        }
        else if (id == R.id.kolor_czerwono_zolte) {
            tlo_pola.setColor(Color.RED);
            tlo_pola2.setColor(Color.YELLOW);
            P.postInvalidate();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class Panel extends View {
        public Panel(Context context) {
            super(context);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.GRAY);

            float width = getWidth();
            float height = getHeight();


            float rozmiarSzachownicy = min(width, height);
            float rozmiarPola = rozmiarSzachownicy / 8;

            for (int i = 0; i < 8; i++) {

                for (int j = 0; j < 8; j++)
                {
                    if ((i + j) % 2 == 0) {
                        canvas.drawRect(
                                i * rozmiarPola,
                                j * rozmiarPola,
                                (i + 1) * rozmiarPola,
                                (j + 1) * rozmiarPola,
                                tlo_pola);
                    }
                    else {
                        canvas.drawRect(
                                i * rozmiarPola,
                                j * rozmiarPola,
                                (i + 1) * rozmiarPola,
                                (j + 1) * rozmiarPola,
                                tlo_pola2);
                    }
                }
            }
        }
    }
}