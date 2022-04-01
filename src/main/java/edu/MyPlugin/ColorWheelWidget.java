package edu.MyPlugin;

import edu.wpi.first.shuffleboard.api.prefs.Group;
import edu.wpi.first.shuffleboard.api.prefs.Setting;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;

import com.google.common.collect.ImmutableList;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

@Description(
    name = "Color Wheel",
    dataTypes = String.class)
@ParametrizedController("ColorWheelWidget.fxml")
public class ColorWheelWidget extends SimpleAnnotatedWidget<String> {

  @FXML
  private Pane root;

  private final Property<Color> color1
      = new SimpleObjectProperty<>(this, "color 1", Color.GREEN);
  private final Property<Color> color2
      = new SimpleObjectProperty<>(this, "color 2", Color.RED);
  private final Property<Color> color3
      = new SimpleObjectProperty<>(this, "color 3", Color.YELLOW);
  private final Property<Color> color4
      = new SimpleObjectProperty<>(this, "color 4", Color.BLUE);

  private final Property<String> colorName1 = new SimpleObjectProperty<>(this, "Color Name 1", "green");
  private final Property<String> colorName2 = new SimpleObjectProperty<>(this, "Color Name 2", "red");
  private final Property<String> colorName3 = new SimpleObjectProperty<>(this, "Color Name 3", "yellow");
  private final Property<String> colorName4 = new SimpleObjectProperty<>(this, "Color Name 4", "blue");

  @FXML
  private void initialize() {
    root.backgroundProperty().bind(
        Bindings.createObjectBinding(
            () -> createSolidColorBackground(getColor()),
            dataProperty(), color1, color2, color3, color4));
  }

  @Override
  public List<Group> getSettings() {
    return ImmutableList.of(
        Group.of("Colors",
            Setting.of("Wheel Color 1", "The color to use when the value is `color1`", color1, Color.class),
            Setting.of("Wheel Color 2", "The color to use when the value is `color2`", color2, Color.class),
            Setting.of("Wheel Color 3", "The color to use when the value is `color3`", color3, Color.class),
            Setting.of("Wheel Color 4", "The color to use when the value is `color4`", color4, Color.class)
        ),

        Group.of("Color Names",
        Setting.of("Wheel Color Name 1", "The name of color 1", colorName1, String.class),
        Setting.of("Wheel Color Name 2", "The name of color 2", colorName2, String.class),
        Setting.of("Wheel Color Name 3", "The name of color 3", colorName3, String.class),
        Setting.of("Wheel Color Name 4", "The name of color 4", colorName4, String.class)
        )
    );
  }

  @Override
  public Pane getView() {
    return root;
  }

  private Color getColor() {
    String data = getData();
    if (data == null) {
      return Color.BLACK;
    }

    if (data.equalsIgnoreCase(colorName1.getValue())) {
      return color1.getValue();
    } else if(data.equalsIgnoreCase(colorName2.getValue())){
      return color2.getValue();
    } else if(data.equalsIgnoreCase(colorName3.getValue())){
      return color3.getValue(); 
    } else if(data.equalsIgnoreCase(colorName4.getValue())){
      return color4.getValue(); 
    }else{
      return Color.BLACK;
    }
  }

  private Background createSolidColorBackground(Color color) {
    return new Background(new BackgroundFill(color, null, null));
  }

  //Get
  public Color getColor1() {
    return color1.getValue();
  }
  public Color getColor2() {
    return color2.getValue();
  }
  public Color getColor3() {
    return color3.getValue();
  }
  public Color getColor4() {
    return color4.getValue();
  }

  public String getColorName1() {
    return colorName1.getValue();
  }
  public String getColorName2() {
    return colorName1.getValue();
  }
  public String getColorName3() {
    return colorName1.getValue();
  }
  public String getColorName4() {
    return colorName1.getValue();
  }


  public Property<Color> color1Property() {
    return color1;
  }
  public Property<Color> color2Property() {
    return color2;
  }
  public Property<Color> color3Property() {
    return color3;
  }
  public Property<Color> color4Property() {
    return color4;
  }

  public Property<String> colorName1Property() {
    return colorName1;
  }
  public Property<String> colorName2Property() {
    return colorName1;
  }
  public Property<String> colorName3Property() {
    return colorName1;
  }
  public Property<String> colorName4Property() {
    return colorName1;
  }

  //Set
  public void setcolor1(Color color1) {
    this.color1.setValue(color1);
  }
  public void setcolor2(Color color2) {
    this.color2.setValue(color2);
  }
  public void setcolor3(Color color3) {
    this.color3.setValue(color3);
  }
  public void setcolor4(Color color4) {
    this.color4.setValue(color4);
  }

  public void setcolor1(String colorName1) {
    this.colorName1.setValue(colorName1);
  }
  public void setcolor2(String colorName2) {
    this.colorName1.setValue(colorName2);
  }
  public void setcolor3(String colorName3) {
    this.colorName1.setValue(colorName3);
  }
  public void setcolor4(String colorName4) {
    this.colorName1.setValue(colorName4);
  }

}
