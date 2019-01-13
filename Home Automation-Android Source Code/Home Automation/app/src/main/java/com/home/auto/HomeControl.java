package com.home.auto;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.UUID;


public class HomeControl extends ActionBarActivity {

    Switch l1, l2, l3, l4, l5, l6, l7, l8;
    Button  Discnt, Abt;
    TextView txt_l, txt_2, txt_3, txt_4, txt_5, txt_6, txt_7, txt_8;
    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    //SPP UUID. Look for it
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceList.EXTRA_ADDRESS); //receive the address of the bluetooth device

        //view of the HomeControl
        setContentView(R.layout.activity_home_control);
        new ConnectBT().execute(); //Call the class to connect

        //call the widgets
        l1 = (Switch)findViewById(R.id.device1);
        l2 = (Switch)findViewById(R.id.device2);
        l3 = (Switch)findViewById(R.id.device3);
        l4 = (Switch)findViewById(R.id.device4);
        l5 = (Switch)findViewById(R.id.device5);
        l6 = (Switch)findViewById(R.id.device6);
        l7 = (Switch)findViewById(R.id.device7) ;
        l8 = (Switch)findViewById(R.id.device8) ;
        Discnt = (Button)findViewById(R.id.discnt);
        Abt = (Button)findViewById(R.id.abt);
        Discnt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Disconnect(); //close connection
            }
        });
    }

    public void device1(View view)
    {
        txt_l = (TextView)findViewById(R.id.light1_text);
        boolean sw1 = ((Switch) view).isChecked();
        if(sw1)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("a".toString().getBytes());
                    txt_l.setText("Device 1 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("b".toString().getBytes());
                    txt_l.setText("Device 1 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
    }

    public void  device2(View view)
    {
        txt_2 = (TextView)findViewById(R.id.light2_text);
        boolean sw2 = ((Switch) view).isChecked();
        if(sw2)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("c".toString().getBytes());
                    txt_2.setText("Device 2 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("d".toString().getBytes());
                    txt_2.setText("Device 2 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
    }

    public void  device3(View view)
    {
        txt_3 = (TextView)findViewById(R.id.light3_text);
        boolean sw3 = ((Switch) view).isChecked();
        if(sw3)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("e".toString().getBytes());
                       txt_3.setText("Device 3 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("f".toString().getBytes());
                    txt_3.setText("Device 3 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }

    }

    public void device4(View view)
    {
        txt_4 = (TextView)findViewById(R.id.TV_text);
        boolean sw4 = ((Switch) view).isChecked();
        if(sw4)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("g".toString().getBytes());
                    txt_4.setText("Device 4 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("h".toString().getBytes());
                    txt_4.setText("Device 4 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
    }

    public void device5(View view)
    {
        txt_5 = (TextView)findViewById(R.id.fan_text);
        boolean sw5 = ((Switch) view).isChecked();
        if(sw5)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("i".toString().getBytes());
                    txt_5.setText("Device 5 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("j".toString().getBytes());
                    txt_5.setText("Device 5 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
    }

    public void device6(View view) {
        txt_6 = (TextView)findViewById(R.id.lock_text);
        boolean sw6 = ((Switch) view).isChecked();
        if(sw6)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("k".toString().getBytes());
                    txt_6.setText("Device 6 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("l".toString().getBytes());
                    txt_6.setText("Device 6 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
    }

    public void device7(View view) {
        txt_7 = (TextView)findViewById(R.id.lock_text);
        boolean sw7 = ((Switch) view).isChecked();
        if(sw7)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("m".toString().getBytes());
                    txt_7.setText("Device 7 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("n".toString().getBytes());
                    txt_7.setText("Device 7 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
    }

    public void device8(View view) {
        txt_8 = (TextView)findViewById(R.id.lock_text);
        boolean sw8 = ((Switch) view).isChecked();
        if(sw8)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("o".toString().getBytes());
                    txt_8.setText("Device 8 ON");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
        else
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("p".toString().getBytes());
                    txt_8.setText("Device 8 OFF");

                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }
        }
    }



    private void Disconnect()
    {
        if (btSocket!=null) //If the btSocket is busy
        {
            try
            {
                btSocket.close(); //close connection
            }
            catch (IOException e)
            { msg("Error");}
        }
        finish(); //return to the first layout

    }


    // fast way to call Toast
    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    public  void about(View v)
    {
        if(v.getId() == R.id.abt)
        {
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_led_control, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(HomeControl.this, "Connecting...", "Please wait!!!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                 myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                 BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                 btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                 BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                 btSocket.connect();//start connection
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
