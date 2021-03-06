package me.desht.pneumaticcraft.client.render.tileentity;

import me.desht.pneumaticcraft.client.model.block.ModelVacuumPump;
import me.desht.pneumaticcraft.common.tileentity.TileEntityVacuumPump;
import me.desht.pneumaticcraft.common.util.PneumaticCraftUtils;
import me.desht.pneumaticcraft.lib.Textures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

public class RenderVacuumPump extends AbstractModelRenderer<TileEntityVacuumPump> {
    private final ModelVacuumPump model;

    public RenderVacuumPump() {
        model = new ModelVacuumPump();
    }

    @Override
    ResourceLocation getTexture(TileEntityVacuumPump te) {
        return Textures.MODEL_VACUUM_PUMP;
    }

    @Override
    void renderModel(TileEntityVacuumPump te, float partialTicks) {
        if (te != null) {
            PneumaticCraftUtils.rotateMatrixByMetadata(te.getBlockMetadata());
            GlStateManager.rotate(-90, 0, 1, 0);
            model.renderModel(0.0625f, te.oldRotation + (te.rotation - te.oldRotation) * partialTicks);
        } else {
            model.renderModel(0.0625f, 0);
        }
    }
}
