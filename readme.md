# AutoSprite

Generate even tilesheets from non-equally spaced tilesheets.

## Description

Autosprite reads in an image and finds the background color by finding the color with the most pixels. It then finds all non-background pixels (foreground pixels) and adds them to a list of 'seeds'. For each seed pixel, we walk all neighbor pixels and add them to the 'sprite' if they're also foreground pixels. Once we have a complete sprite, we remove all of its pixels from our list of seeds. We repeat that until we have no more seeds, and instead have a list of sprites. 

We can calculate the bounding box of a sprite by grabbing the min and max x and y values for any of its pixels. Once we have all the bounding boxes, we can figure out the minimum grid size needed to accommodate them all uniformly. With grid information we can now write a new image where the sprites are all spaced uniformly based on the grid.



## TODO

Allow for multiple grids in same picture (for different sized sprites)
- would require increments of 8 or something
- probably not helpful since could re-order sprites too much. Better to let the user just pick/edit shots to just have similar sized sprites


