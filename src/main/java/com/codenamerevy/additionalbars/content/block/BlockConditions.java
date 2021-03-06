package com.codenamerevy.additionalbars.content.block;

import com.codenamerevy.additionalbars.util.ModSupport;
import com.codenamerevy.additionalbars.util.Ref;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class BlockConditions implements ICondition
{
    public static final ResourceLocation NAME = new ResourceLocation(Ref.MODID, "blocks");
    public static String OBJECT;

    public BlockConditions(String object)
    {
        this.OBJECT = object;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test() {
        if(OBJECT.equals("BOP"))        return ModSupport.BOP.isLoaded();
        if(OBJECT.equals("Corail"))     return ModSupport.CORAIL.isLoaded();
        if(OBJECT.equals("Quark"))      return ModSupport.QUARK.isLoaded();


        if(OBJECT.equals("BOPNOT"))        return !ModSupport.BOP.isLoaded();
        if(OBJECT.equals("CorailNOT"))     return !ModSupport.CORAIL.isLoaded();
        if(OBJECT.equals("QuarkNOT"))      return !ModSupport.QUARK.isLoaded();
        return false;
    }

    public static class Serializer implements IConditionSerializer<BlockConditions> {
        public static final BlockConditions.Serializer INSTANCE = new BlockConditions.Serializer();

        @Override
        public void write(JsonObject json, BlockConditions value) {

        }

        @Override
        public BlockConditions read(JsonObject json) {
            return new BlockConditions(json.get("object").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return NAME;
        }
    }
}
