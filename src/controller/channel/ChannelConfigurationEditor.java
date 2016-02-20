/*******************************************************************************

 *     SDR Trunk 
 *     Copyright (C) 2014-2016 Dennis Sheirer
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
package controller.channel;

import javax.swing.JPanel;

public abstract class ChannelConfigurationEditor extends JPanel
{
    private static final long serialVersionUID = 1L;

    /**
     * Sets or resets the configuration editor components
     */
    public abstract void setConfiguration( Channel channel );
    
    /**
     * Saves the contents of the editor components to the configuration
     */
    public abstract void save();
    
    /**
     * Validates the contents of the editor components prior to saving the 
     * content to the configuration.
     * 
     * @throws ConfigurationValidationException if the content is invalid
     */
    public abstract void validateConfiguration() throws ConfigurationValidationException;
}