package investcrip.com.invest_crip.features.register.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import investcrip.com.invest_crip.features.register.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public CustomerDAOImpl(Context context) {
        DbHelperCustomer db = new DbHelperCustomer( context );
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean save(Customer customer) {
        ContentValues cv = new ContentValues();
        cv.put("name", customer.getName() );
        cv.put("email", customer.getEmail());
        cv.put("cpf", customer.getCpf());
        cv.put("birthday", customer.getBirthday());
        cv.put("phoneNumber", customer.getPhoneNumber());
        cv.put("balance", customer.getBalance());

        try {
            write.insert(DbHelperCustomer.CUSTOMER_TABLE, null, cv );
        }catch (Exception e){
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Customer customer) {
        ContentValues cv = new ContentValues();
        cv.put("name", customer.getName() );
        cv.put("email", customer.getEmail());
        cv.put("cpf", customer.getCpf());
        cv.put("birthday", customer.getBirthday());
        cv.put("phoneNumber", customer.getPhoneNumber());
        cv.put("balance", customer.getBalance());

        try {
            String[] args = {customer.getId().toString()};
            write.update(DbHelperCustomer.CUSTOMER_TABLE, cv, "id=?", args );
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizada tarefa " + e.getMessage() );
            return false;
        }

        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        try {
            String[] args = { customer.getId().toString() };
            write.delete(DbHelperCustomer.CUSTOMER_TABLE, "id=?", args );
        }catch (Exception e){
            Log.e("INFO", "Erro ao remover tarefa " + e.getMessage() );
            return false;
        }
        return true;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelperCustomer.CUSTOMER_TABLE + ";";
        Cursor c = read.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Customer customer = new Customer();

            Long id = c.getLong( c.getColumnIndex("id") );
            String name = c.getString( c.getColumnIndex("name") );
            String email = c.getString( c.getColumnIndex("email") );
            String cpf = c.getString( c.getColumnIndex("cpf") );
            String birthday = c.getString( c.getColumnIndex("birthday") );
            String phoneNumber = c.getString( c.getColumnIndex("phoneNumber") );
            String balance = c.getString( c.getColumnIndex("balance") );

            customer.setId( id );
            customer.setName( name );
            customer.setEmail( email );
            customer.setCpf( cpf );
            customer.setBirthday( birthday );
            customer.setPhoneNumber( phoneNumber );
            customer.setBalance( balance );



            tarefas.add( customer );
        }

        return tarefas;
    }
}
