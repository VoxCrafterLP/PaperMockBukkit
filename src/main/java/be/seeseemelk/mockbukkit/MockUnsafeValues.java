package be.seeseemelk.mockbukkit;

import com.google.common.collect.Multimap;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.UnsafeValues;
import org.bukkit.advancement.Advancement;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class MockUnsafeValues implements UnsafeValues
{

	private final Set<String> compatibleApiVersions = new HashSet<>(Arrays.asList("1.13", "1.14", "1.15", "1.16", "1.17", "1.18"));

	public ComponentFlattener componentFlattener()
	{
		return ComponentFlattener.basic();
	}

	public PlainComponentSerializer plainComponentSerializer()
	{
		return PlainComponentSerializer.plain();
	}

	public PlainTextComponentSerializer plainTextSerializer()
	{
		return PlainTextComponentSerializer.plainText();
	}

	public GsonComponentSerializer gsonComponentSerializer()
	{
		return GsonComponentSerializer.gson();
	}

	public GsonComponentSerializer colorDownsamplingGsonComponentSerializer()
	{
		return GsonComponentSerializer.colorDownsamplingGson();
	}

	public LegacyComponentSerializer legacyComponentSerializer()
	{
		return LegacyComponentSerializer.legacySection();
	}

	@Override
	public Material toLegacy(Material material)
	{
		if (material.isLegacy())
		{
			return material;
		}
		throw new UnimplementedOperationException();
	}

	@Override
	public Material fromLegacy(Material material)
	{
		return material;
	}

	@Override
	public Material fromLegacy(MaterialData material)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public Material fromLegacy(MaterialData material, boolean itemPriority)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public BlockData fromLegacy(Material material, byte data)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public int getDataVersion()
	{
		return 1;
	}

	@Override
	public ItemStack modifyItemStack(ItemStack stack, String arguments)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public void checkSupported(PluginDescriptionFile pdf) throws InvalidPluginException
	{
		if (pdf.getAPIVersion() == null)
			throw new InvalidPluginException("Plugin does not specify 'api-version' in plugin.yml");

		if (!compatibleApiVersions.contains(pdf.getAPIVersion()))
			throw new InvalidPluginException(String.format("Plugin api version %s is incompatible with the current MockBukkit version", pdf.getAPIVersion()));
	}

	@Override
	public byte[] processClass(PluginDescriptionFile pdf, String path, byte[] clazz)
	{
		return clazz;
	}

	@Override
	public Advancement loadAdvancement(NamespacedKey key, String advancement)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public boolean removeAdvancement(NamespacedKey key)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(Material material, EquipmentSlot slot)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public Material getMaterial(String material, int version)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

}
