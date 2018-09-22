import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.styletest.R;

import java.util.List;

public class FruitAdapt extends ArrayAdapter {
    private int resourceId;

    public FruitAdapt(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitText = (TextView) view.findViewById(R.id.fruit_text);
        fruitImage.setImageResource(fruit.getImageId());
        fruitText.setText(fruit.getName());
        return view;
    }

    private void initFruit(){
        Fruit apple = new Fruit("apple", R.drawable.apple_pic);

    }
}
