# Minecraft-Geoglyph
Geoglyph in minecraft

# Commands
## Generate Geoglyph
`/geoglyph gen [BLOCK PATTERN] [RESIZE %] [DIRECTON] [SPEED] [URL]`
### BLOCK PATTERN
This comes with these settings.

- WOOL
- CONCRETE
- CONCRETE_POWDER
- TERRACOTTA
- STONE
- DIRT
- PLANKS
- ORE
- WOOD
- SAND
- SPONGE
- PURPUR
- MARINE
- DECORATION
- SHULKER_BOX
- GLAZED_TERRACOTTA
- RESTONE
- OTHERS
- ALL

You can combine these setting like this.<br>
`ALL,!SHULKER_BOX`<br>
This means block pattern is restricted to the all block types except shulker box.<br>
As you can see , by using `,` , you can combine and using `!` to remove from pattern.

### RESIZE
This is percentage of image size.<br>
0 to 100.

### DIRECTION
This comes with next settings.
- HORIZONTAL
- DIAGONAL
- VERTICAL

### SPEED
This comes with next setting
- VERY SLOW
- SLOW
- MIDDLE
- FAST
- VERY FAST
- ULTRA FAST
- INSTANT

### URL
A url to image.<br>

## Generate mono geoglyph
`/geoglyph gen_mono [RESIZE %] [DIRECTON] [SPEED] [URL]`
RESIZE,DIRECTION,SPEED,URL is as same as normal gen command.

## Cancel generate geoglyph
`/geoglyph cancel`

## Search Near Block
`/geoglyph near_block [R] [G] [B] [0~316]`
