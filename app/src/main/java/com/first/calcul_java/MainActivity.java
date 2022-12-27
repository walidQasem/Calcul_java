package com.first.calcul_java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     TextView resulta,affichage;
    String somme2="";
    boolean isOper=false;
    String operator;
     String somme1;

     Button num1,num2,num3,plus,manis,egal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resulta = findViewById(R.id.resulta);
        affichage = findViewById(R.id.affichage);


        getid(R.id.num1);
        getid(R.id.num9);
        getid(R.id.num8);
        getid(R.id.num5);
        getid(R.id.num0);
        getid(R.id.num3);
        getid(R.id.num44);
        getid(R.id.num6);
        getid(R.id.num4);
        getid(R.id.num7);
        getid(R.id.egal);
        getid(R.id.plus);
        getid(R.id.munis);
        getid(R.id.poin);
        getid(R.id.dev);
        getid(R.id.pui);
        getid(R.id.c);
        getid(R.id.x);
    }




    void calculer(){
        somme2=resulta.getText().toString();
            if(isOper == true && somme2!=""){
                if(operator=="*") {
                    resulta.setText(Float.parseFloat(somme1) * Float.parseFloat(somme2) + "");
                    affichage.setText(Float.parseFloat(somme1) * Float.parseFloat(somme2) + "");
                    operator="";
                }
                if(operator=="-") {
                    resulta.setText(Float.parseFloat(somme1) - Float.parseFloat(somme2) + "");
                    affichage.setText(Float.parseFloat(somme1) - Float.parseFloat(somme2) + "");
                    operator="";
                }
                if(operator=="/") {
                    resulta.setText(Float.parseFloat(somme1) / Float.parseFloat(somme2) + "");
                    affichage.setText(Float.parseFloat(somme1) / Float.parseFloat(somme2) + "");
                    operator="";
                }
                if(operator=="+") {
                    resulta.setText(Float.parseFloat(somme1) + Float.parseFloat(somme2) + "");
                    affichage.setText(Float.parseFloat(somme1) + Float.parseFloat(somme2) + "");
                    operator="";
                }
            }
            if(operator==null || resulta.getText().equals("0")){
                resulta.setText(resulta.getText());
            }
            isOper=false;
        }


      String opp="";
  void Operator(Button btne,String op){
        opp="";
      if(btne.getText().equals(op)){
          if(affichage.equals("0") || affichage.equals("")){
              affichage.setText("0");
          }
          if(isOper==true){
              opp=op;
          }
          if(isOper==false){
              operator = op;
              somme1 = resulta.getText().toString();
              resulta.setText("");
              opp=op;
              affichage.setText(affichage.getText()+opp);
              isOper=true;
          }


          if(somme2==""){
              somme2=resulta.getText().toString();
              isOper=true;
          }
          if(somme2!=""){
              calculer();
              operator=op;
              somme2="";
              isOper=false;
              if(isOper==false) {
                  operator = op;
                  affichage.setText(affichage.getText()+operator);
                  somme1 = resulta.getText().toString();
                  resulta.setText("");
                  isOper=true;
              }
          }

      }
  }




    void getid(int rid){
        Button btne = findViewById(rid);

        btne.setOnClickListener(new View.OnClickListener() {
             @SuppressLint("SetTextI18n")
             @Override
             public void onClick(View v) {


                 if( !btne.getText().equals("C") && !btne.getText().equals("=") &&
                         !btne.getText().equals("x") &&
                         !btne.getText().equals("+") &&
                         !btne.getText().equals("-") &&
                         !btne.getText().equals("*") &&
                         !btne.getText().equals("/")){
                     affichage.setText(affichage.getText()+btne.getText().toString());
                 }


                 if( !btne.getText().equals("C") &&
                         !btne.getText().equals("=") &&
                         !btne.getText().equals("+") &&
                         !btne.getText().equals("-") &&
                         !btne.getText().equals("*") &&
                         !btne.getText().equals("/")){
                     resulta.setText(resulta.getText()+btne.getText().toString());

                 }


                 if(btne.getText().equals("C")){
                     resulta.setText("0");
                     affichage.setText("0");
                     somme2="";
                     somme1="";
                     isOper=false;
                 }


                 Operator(btne,"+");
                 Operator(btne,"-");
                 Operator(btne,"/");
                 Operator(btne,"*");

              if(btne.getText().equals("=")){
                  calculer();
                  if(somme2==""){
                      affichage.setText(somme1);
                      resulta.setText(somme1);
                  }
                  somme2="";
              }



                 if(btne.getText().equals("x")){
                   int  l = resulta.getText().toString().length();
                   if(l==1){
                       resulta.setText("0");
                   }
                   else {
                       resulta.setText(resulta.getText().toString().substring(0, l - 2));
                   }
                 }



             }
         });
    }
}