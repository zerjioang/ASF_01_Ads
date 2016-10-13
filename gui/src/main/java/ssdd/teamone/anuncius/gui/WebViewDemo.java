package ssdd.teamone.anuncius.gui;

import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import ssdd.teamone.anuncius.gui.demo.RandomNameService;

import static ssdd.teamone.anuncius.gui.magic.webview.Java2JavascriptUtils.connectBackendObject;

public class WebViewDemo extends Application {

	private final String PAGE = "/demo.html";

	@Override
	public void start(Stage primaryStage) {
		createWebView(primaryStage, PAGE);
	}

	private void createWebView(Stage primaryStage, String page) {
		
		// create the JavaFX webview
		final WebView webView = new WebView();
		final WebEngine engine = webView.getEngine();
		
		// connect the CalculatorService instance as "calculatorService" 
		// javascript variable		
		connectBackendObject(
				engine,
				"randomNameService", new RandomNameService());
		
		// show "alert" Javascript messages in stdout (useful to debug)	
		engine.setOnAlert(arg0 -> System.err.println(arg0.toString()));
		
		// load index.html
		engine.load(
				getClass().getResource(page).
				toExternalForm());

		webView.setCache(true);
		webView.setCacheHint(CacheHint.SPEED);

		primaryStage.setScene(new Scene(webView));
		primaryStage.setTitle("Demo");
		primaryStage.show();
	}
	
	public static void main(String[] args) {		
		System.setProperty("prism.lcdtext", "false"); // enhance fonts		
		launch(args);
	}
}
