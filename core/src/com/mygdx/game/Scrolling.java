package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

public class Scrolling extends ApplicationAdapter {
	SpriteBatch batch;
	ScrollPane scrollPane;
	Texture img;
	SBSprite sbsprite;
	Stage stage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sbsprite = new SBSprite(img);
		scrollPane = new ScrollPane(sbsprite);
		scrollPane.setPosition(150, 150);
		stage = new Stage();
		Gdx.input.setInputProcessor(this.stage);
		stage.addActor(scrollPane);


	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(img, 0,/ 0);/
//		stage.act();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		batch.end();
	}
}
