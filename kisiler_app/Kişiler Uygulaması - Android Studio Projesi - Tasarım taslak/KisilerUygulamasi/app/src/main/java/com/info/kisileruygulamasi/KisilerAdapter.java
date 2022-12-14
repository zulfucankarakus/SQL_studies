package com.info.kisileruygulamasi;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * Created by kasimadalan on 4.05.2018.
 */

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kisiler> kisilerListe;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerListe) {
        this.mContext = mContext;
        this.kisilerListe = kisilerListe;
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kisi_card_tasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(final CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerListe.get(position);

        holder.textViewKisiBilgi.setText(kisi.getKisi_ad()+" - "+kisi.getKisi_tel());

        holder.─▒mageViewNokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(mContext,holder.─▒mageViewNokta);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.action_sil:
                                Snackbar.make(holder.─▒mageViewNokta,"Sil T─▒kland─▒", Snackbar.LENGTH_SHORT).show();
                                return  true;
                            case R.id.action_guncelle:
                                alertGoster();
                                return  true;
                            default:
                                return false;
                        }



                    }
                });

                popupMenu.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return kisilerListe.size();
    }



    public class CardTasarimTutucu extends RecyclerView.ViewHolder{

        private TextView textViewKisiBilgi;
        private ImageView ─▒mageViewNokta;

        public CardTasarimTutucu(View itemView) {
            super(itemView);

            textViewKisiBilgi = itemView.findViewById(R.id.textViewKisiBilgi);
            ─▒mageViewNokta = itemView.findViewById(R.id.imageViewNokta);
        }
    }


    public void alertGoster(){

        LayoutInflater layout = LayoutInflater.from(mContext);

        View tasarim = layout.inflate(R.layout.alert_tasarim,null);

        final EditText editTextAd = tasarim.findViewById(R.id.editTextAd);
        final EditText editTextTel = tasarim.findViewById(R.id.editTextTel);

        AlertDialog.Builder ad = new AlertDialog.Builder(mContext);
        ad.setTitle("Ki┼či G├╝ncelle");
        ad.setView(tasarim);
        ad.setPositiveButton("G├╝ncelle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String kisi_ad = editTextAd.getText().toString().trim();
                String kisi_tel = editTextTel.getText().toString().trim();

                Toast.makeText(mContext,kisi_ad+" - "+kisi_tel, Toast.LENGTH_SHORT).show();
            }
        });

        ad.setNegativeButton("─░ptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        ad.create().show();
    }


}
