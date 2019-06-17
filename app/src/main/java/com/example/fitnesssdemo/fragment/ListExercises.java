package com.example.fitnesssdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListExercises extends AppCompatActivity {
    private ListView listView;
    private List<com.example.fitnesssdemo.Exercise> exercises;
    private com.example.fitnesssdemo.ExerciseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises);
        init();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListExercises.this, com.example.fitnesssdemo.DisplayExercise.class);
                intent.putExtra("id",exercises.get(position).getId());
                intent.putExtra("name",exercises.get(position).getName());
                intent.putExtra("detail",exercises.get(position).getDetail());
                startActivity(intent);
            }
        });
    }

    private void init() {
        listView = findViewById(R.id.lvExercise);
        exercises = new ArrayList<>();
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.pushup,"Chống đẩy","Nằm nghiêng trên mặt đất với cánh tay đỡ cơ thể bạn. Giữ cho cơ thể thẳng trong khi nâng và hạ cơ thể bằng tay."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.benchpress,"Bài tập ngực 1","Nắm tạ với hai tay cách nhau ở mức trung , nâng tạ ra khỏi giá và giữ thẳng nó phía trên.Hạ xuống cho đến khi tạ chạm ngực giữa của bạn. Sau đó đẩy tạ lên tới vị trí bắt đầu trong khi thở ra."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.dumbellbenchpress,"Bài tập ngực 2","Nằm trên ghế với tạ đôi ở trên hai tay. Sau đó, thở ra và sử dụng cơ ngực để nâng tạ lên. Giữ thẳng cánh tay khi nâng tạ đến điểm cao nhất và gồng ngực, giữ 1s sau đó đi xuống từ từ."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.shoulderoverhead,"Bài tập vai 1","Ngồi trên ghế thẳng lưng, hai tay cầm thanh đòn tạ từ từ nâng lên sao cho hai tay vươn ra hết. Sau đó hít vào và từ từ hạ thanh đòn xuống."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.shoulderdumbell,"Bài tập vai 2","Ngồi ghế thẳng lưng, hai tay cầm tạ đơn thở ra và nâng tạ lên cao sao cho hai tạ đơn chạm vào nhau. Sau đó hít vào và từ từ hạ cánh tay xuống."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.abs1,"Bài tập bụng 1","Tư thế nằm xuống đất, hai tay giữ lực xuống mặt đấy rồi nâng hai chân lên sao cho đùi vuông góc với mặt đấy, thở ra khi thực hiện. Sau khi nâng lên, hít vào và từ từ hạ xuống."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.abs2,"Bài tập bụng 2","Hai tay nắm chặt lấy thanh xà, dùng lực hông đưa hai chân lên sao cho đầu gối chạm vào bụng rồi từ từ hạ và duỗi hai chân xuống."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.leg,"Bài tập chân 1","Ngồi thẳng, hai tai nắm chắc hai tay cầm. Sau đó dùng lực chân đưa tạ ở máy lên sao cho chân duỗi thẳng ra rồi từ từ thu chân về tư thế ban đầu."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.leg2,"Bài tập chân 2","Hai tay cầm 2 tạ đơn bước 1 chân lên bục trước rồi chân còn lại lên theo sau. Sau đó từ từ 1 chân xuống và chân kia theo sau."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.deadlift,"Bài tập Deadlift","Đứng thẳng người hai tay cầm thanh tạ rồi từ từ cúi người đưa thanh tạ xuống đất nhưng vẫn phải giữ cho đầu thẳng lên. Sau đó thở ra và kéo tạ lên thật nhanh."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.squat,"Bài tập Squat","Đứng thẳng người hai tay giữ thanh đòn tạ trên lưng rồi từ từ ngồi xuống đến khi đầu gối và chân tạo thành vuông góc. Sau đó thở ra và đứng lên thật nhanh."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.biceps,"Bài tập tay trước","Hai tay cầm thanh tạ đón thở ra và kéo lên thật nhanh. Sau đó từ từ hạ thanh tạ xuống và hít vào."));
        exercises.add(new com.example.fitnesssdemo.Exercise(R.drawable.tripceps,"Bài tập tay sau","Tư thế người đứng hơi đổ về phía máy tập, hai tay cầm dây cáp kéo sâu xuống đến khi duỗi thẳng tay rồi giữ cho dây cáp kéo lên.."));


        adapter = new com.example.fitnesssdemo.ExerciseAdapter(this,R.layout.row_exercise,exercises);
        listView.setAdapter(adapter);
    }
}
