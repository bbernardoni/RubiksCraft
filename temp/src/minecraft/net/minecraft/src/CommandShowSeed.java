package net.minecraft.src;

import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICommandSender;

public class CommandShowSeed extends CommandBase {

   public String func_71517_b() {
      return "seed";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      EntityPlayer var3 = func_71521_c(p_71515_1_);
      p_71515_1_.func_70006_a("Seed: " + var3.field_70170_p.func_72905_C());
   }
}
