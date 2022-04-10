package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Random;

import static dk.sdu.mmmi.cbse.asteroidsystem.AsteroidType.Large;

public class AsteroidPlugin implements IGamePluginService, IPostEntityProcessingService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        asteroid = createLargeAsteroid(gameData);
        world.addEntity(asteroid);
    }


    private Entity createLargeAsteroid(GameData gameData) {

        float speed = (float) Math.random()*10f+40f;
        float radians = 3.1415f / 2+(float)Math.random();
        float x = gameData.getDisplayWidth() / 2+100;
        float y = gameData.getDisplayHeight() / 2+50;

        
        Entity asteroid = new Asteroid(Large);
        asteroid.setRadius(15);

        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new LifePart(1,5));


        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

    @Override
    public void process(GameData gameData, World world) {

    }
}
