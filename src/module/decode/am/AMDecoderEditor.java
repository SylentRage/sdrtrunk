/*******************************************************************************
 *     SDR Trunk 
 *     Copyright (C) 2014 Dennis Sheirer
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package module.decode.am;

import gui.editor.Editor;
import gui.editor.EditorValidationException;
import gui.editor.ValidatingEditor;
import controller.channel.Channel;

public class AMDecoderEditor extends ValidatingEditor<Channel>
{
    private static final long serialVersionUID = 1L;
    
	public AMDecoderEditor()
	{
	}

	@Override
	public boolean isValid( Editor<Channel> editor ) throws EditorValidationException
	{
		return true;
	}

	@Override
	public void save()
	{
		if( hasItem() && isModified() )
		{
			getItem().setDecodeConfiguration( new DecodeConfigAM() );
		}
		
		setModified( false );
	}
}