package investcrip.com.invest_crip.features.register.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelperCustomer extends SQLiteOpenHelper {
    public static int VERSION = 1;
    public static String DB_NAME = "DB_CUSTOMER";
    public static String CUSTOMER_TABLE = "customer";

    public DbHelperCustomer(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + CUSTOMER_TABLE
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT NOT NULL, " +
                " email TEXT NOT NULL, " +
                " cpf TEXT NOT NULL, " +
                " bithday TEXT NOT NULL, " +
                " phoneNumber TEXT NOT NULL, " +
                " balance TEXT NOT NULL ); ";


        try {
            db.execSQL( sql );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + CUSTOMER_TABLE + " ;" ;

        try {
            db.execSQL( sql );
            onCreate(db);
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage() );
        }
    }
}
