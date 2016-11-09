package com.fuicuiedu.idedemo.interview_analysis.xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fuicuiedu.idedemo.interview_analysis.R;
import com.fuicuiedu.idedemo.interview_analysis.entity.Book;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        ButterKnife.bind(this);
        SAXparser();
    }

    @OnClick({R.id.xml_sax_btn,R.id.xml_dom_btn,R.id.xml_pull_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.xml_sax_btn:
                SAXparser();
                break;
            case R.id.xml_dom_btn:
                break;
            case R.id.xml_pull_btn:
                break;

        }
    }

    //SAX解析xml
    private void SAXparser(){
        try {
            InputStream inputStream = getAssets().open("Books.xml");
            SaxBookParser saxBookParser = new SaxBookParser();
            List<Book> books = saxBookParser.parse(inputStream);
            for (Book book : books){
                Log.e("SaxParser",book.toString());
            }
        } catch (Exception e) {

        }
    }

}
