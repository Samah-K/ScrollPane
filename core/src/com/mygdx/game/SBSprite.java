package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SBSprite extends Image {

    private int zIndex;
    public SBSprite() {
        super();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(this.getColor());
        ((TextureRegionDrawable)getDrawable()).draw(batch, getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation());
    }


    public SBSprite(Texture texture){
        super(texture);
        zIndex = 0;
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin(getWidth() / 2, getHeight() / 2);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }

    public Actor getActor(){
        return this;
    }

    public TextureRegionDrawable getTextureRegionDrawable(){
        return (TextureRegionDrawable)getDrawable();
    }

    public void addRelativeToActor(SBSprite parentSprite, float xPercentage, float yPercentage){
        if(xPercentage > 1){
            xPercentage = xPercentage / 100;
        }if(yPercentage > 1){
            yPercentage = yPercentage / 100;
        }
        float newX = (parentSprite.getX() + xPercentage * parentSprite.getWidth()) - this.getWidth()/2;
        float newY = (parentSprite.getY() + yPercentage * parentSprite.getHeight()) - this.getHeight()/2;
        this.setPosition(newX,newY);
    }

    public void changeTexture(Texture texture){
        setWidth(texture.getWidth());
        setHeight(texture.getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin(getWidth() / 2, getHeight() / 2);
        this.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
//        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }

    public void setOrigin(float originX, float originY) {
        super.setOrigin(originX, originY);
    }




}
