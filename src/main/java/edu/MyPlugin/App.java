package edu.MyPlugin;

import java.util.List;

import com.google.common.collect.ImmutableList;

import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(group = "Team708_2022_Shuffleboard", name = "Plugin", summary = "plugin for 2022", version = "1.0.0")
public class App extends Plugin {
	@Override
	@SuppressWarnings("all")
	public List<ComponentType> getComponents() {

		return ImmutableList.of(WidgetType.forAnnotatedWidget(ColorWheelWidget.class),
								WidgetType.forAnnotatedWidget(BooleanBoxWidget_Copy.class),
								WidgetType.forAnnotatedWidget(ToggleSwitchWidget_Copy.class),
								WidgetType.forAnnotatedWidget(TextViewWidget_Copy.class)
								);
	}
}
