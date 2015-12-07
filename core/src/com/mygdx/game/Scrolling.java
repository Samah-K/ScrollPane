package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Scrolling extends ApplicationAdapter {
	SpriteBatch batch;
	ScrollPane scrollPane;
	Texture img;
	SBSprite sbsprite;
	SBSprite video;
	SBSprite sfx;
	Stage stage;
	Table table;

//	SB_0008_Video.png
//	SB_0009_SFX.png


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		sbsprite = new SBSprite(img);


		table = new Table();
		video = new SBSprite(new Texture("SB_0008_Video.png"));
		sfx = new SBSprite(new Texture("SB_0009_SFX.png"));
		table.add(video);
		table.row();
		table.add(sfx);
		table.row();

		scrollPane = new ScrollPane(table);
		scrollPane.setSize(220,500);

		scrollPane.setPosition(150, 150);
		scrollPane.setScrollingDisabled(true,false);
		stage = new Stage();
		Gdx.input.setInputProcessor(this.stage);
		stage.addActor(scrollPane);


	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0.40f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		batch.end();
	}
}
