package alias;

import alias.action.AliasAction;
import alias.action.beep.BeepAction;
import alias.action.clip.ClipAction;
import alias.action.script.ScriptAction;
import alias.id.esn.ESNEditor;
import alias.id.esn.Esn;
import alias.id.fleetsync.FleetsyncID;
import alias.id.fleetsync.FleetsyncIDEditor;
import alias.id.lojack.LoJackIDEditor;
import alias.id.lojack.LoJackFunctionAndID;
import alias.id.mdc.MDC1200IDEditor;
import alias.id.mdc.MDC1200ID;
import alias.id.mobileID.MINEditor;
import alias.id.mobileID.Min;
import alias.id.mpt1327.MPT1327ID;
import alias.id.mpt1327.MPT1327IDEditor;
import alias.id.nonrecordable.NonRecordable;
import alias.id.nonrecordable.NonRecordableEditor;
import alias.id.priority.Priority;
import alias.id.priority.PriorityEditor;
import alias.id.siteID.SiteIDEditor;
import alias.id.siteID.SiteID;
import alias.id.status.StatusID;
import alias.id.status.StatusIDEditor;
import alias.id.talkgroup.TalkgroupID;
import alias.id.talkgroup.TalkgroupIDEditor;
import alias.id.uniqueID.UniqueID;
import alias.id.uniqueID.UniqueIDEditor;

public class AliasFactory
{
	public static AliasID copyOf( AliasID id )
	{
		switch( id.getType() )
		{
			case ESN:
				Esn originalESN = (Esn)id;
				Esn copyESN = new Esn();
				copyESN.setEsn( originalESN.getEsn() );
				return copyESN;
			case Fleetsync:
				FleetsyncID originalFleetsyncID = (FleetsyncID)id;
				FleetsyncID copyFleetsyncID = new FleetsyncID();
				copyFleetsyncID.setIdent( originalFleetsyncID.getIdent() );
				return copyFleetsyncID;
			case LTRNetUID:
				UniqueID originalUniqueID = (UniqueID)id;
				UniqueID copyUniqueID = new UniqueID();
				copyUniqueID.setUid( originalUniqueID.getUid() );
				return copyUniqueID;
			case LoJack:
				LoJackFunctionAndID originalLoJackFunctionAndID = (LoJackFunctionAndID)id;
				LoJackFunctionAndID copyLoJackFunctionAndID = new LoJackFunctionAndID();
				copyLoJackFunctionAndID.setFunction( originalLoJackFunctionAndID.getFunction() );
				copyLoJackFunctionAndID.setID( originalLoJackFunctionAndID.getID() );
				return copyLoJackFunctionAndID;
			case MDC1200:
				MDC1200ID originalMDC1200ID = (MDC1200ID)id;
				MDC1200ID copyMDC1200ID = new MDC1200ID();
				copyMDC1200ID.setIdent( originalMDC1200ID.getIdent() );
				return copyMDC1200ID;
			case MIN:
				Min originalMin = (Min)id;
				Min copyMin = new Min();
				copyMin.setMin( originalMin.getMin() );
				return copyMin;
			case MPT1327:
				MPT1327ID originalMPT1327ID = (MPT1327ID)id;
				MPT1327ID copyMPT1327ID = new MPT1327ID();
				copyMPT1327ID.setIdent( originalMPT1327ID.getIdent() );
				return copyMPT1327ID;
			case NonRecordable:
				return new NonRecordable();
			case Priority:
				Priority originalPriority = (Priority)id;
				Priority copyPriority = new Priority();
				copyPriority.setPriority( originalPriority.getPriority() );
				return copyPriority;
			case Site:
				SiteID originalSiteID = (SiteID)id;
				SiteID copySiteID = new SiteID();
				copySiteID.setSite( originalSiteID.getSite() );
				return copySiteID;
			case Talkgroup:
				TalkgroupID originalTalkgroupID = (TalkgroupID)id;
				TalkgroupID copyTalkgroupID = new TalkgroupID();
				copyTalkgroupID.setTalkgroup( originalTalkgroupID.getTalkgroup() );
				return copyTalkgroupID;
			case Status:
				StatusID originalStatusID = (StatusID)id;
				StatusID copyStatusID = new StatusID();
				copyStatusID.setStatus( originalStatusID.getStatus() );
				return copyStatusID;
			default:
		}

		return null;
	}
	
	public static AliasAction copyOf( AliasAction action )
	{
		if( action instanceof BeepAction )
		{
			return new BeepAction();
		}
		else if( action instanceof ClipAction )
		{
			ClipAction originalClip = (ClipAction)action;
			ClipAction copyClip = new ClipAction();
			copyClip.setInterval( originalClip.getInterval() );
			copyClip.setPath( originalClip.getPath() );
			copyClip.setPeriod( originalClip.getPeriod() );
			return copyClip;
		}
		else if( action instanceof ScriptAction )
		{
			ScriptAction originalScript = (ScriptAction)action;
			ScriptAction copyScript = new ScriptAction();
			copyScript.setInterval( originalScript.getInterval() );
			copyScript.setPeriod( originalScript.getPeriod() );
			copyScript.setScript( originalScript.getScript() );
			return copyScript;
		}
		
		return null;
	}
	
	public static Alias copyOf( Alias original )
	{
		Alias copy = new Alias( original.getName() );
		copy.setList( original.getList() );
		copy.setGroup( original.getGroup() );
		copy.setColor( original.getColor() );
		copy.setIconName( original.getIconName() );
		
		for( AliasID id: original.getId() )
		{
			AliasID copyID = copyOf( id );
			
			if( copyID != null )
			{
				copy.addAliasID( copyID );
			}
		}

		for( AliasAction action: original.getAction() )
		{
			AliasAction copyAction = copyOf( action );
			
			if( copyAction != null )
			{
				copy.addAliasAction( copyAction );
			}
		}
		
		return copy;
	}

	public static ComponentEditor<AliasID> getEditor( AliasID aliasID )
	{
		if( aliasID != null )
		{
			switch( aliasID.getType() )
			{
				case ESN:
					return new ESNEditor( aliasID );
				case Fleetsync:
					return new FleetsyncIDEditor( aliasID );
				case LTRNetUID:
					return new UniqueIDEditor( aliasID );
				case LoJack:
					return new LoJackIDEditor( aliasID );
				case MDC1200:
					return new MDC1200IDEditor( aliasID );
				case MIN:
					return new MINEditor( aliasID );
				case MPT1327:
					return new MPT1327IDEditor( aliasID );
				case NonRecordable:
					return new NonRecordableEditor( aliasID );
				case Priority:
					return new PriorityEditor( aliasID );
				case Site:
					return new SiteIDEditor( aliasID );
				case Status:
					return new StatusIDEditor( aliasID );
				case Talkgroup:
					return new TalkgroupIDEditor( aliasID );
				default:
					break;
			}
		}
		
		return new EmptyAliasIDEditor();
	}
	
	public static ComponentEditor<AliasAction> getEditor( AliasAction aliasAction )
	{
		if( aliasAction != null )
		{
			if( aliasAction instanceof BeepAction )
			{
				
			}
			else if( aliasAction instanceof ClipAction )
			{
				
			}
			else if( aliasAction instanceof ScriptAction )
			{
				
			}
		}
		
		return new EmptyAliasActionEditor();
	}
	
	public static AliasID getAliasID( AliasIDType type )
	{
		switch( type )
		{
			case ESN:
				return new Esn();
			case Fleetsync:
				return new FleetsyncID();
			case LTRNetUID:
				return new UniqueID();
			case LoJack:
				return new LoJackFunctionAndID();
			case MDC1200:
				return new MDC1200ID();
			case MIN:
				return new Min();
			case MPT1327:
				return new MPT1327ID();
			case NonRecordable:
				return new NonRecordable();
			case Priority:
				return new Priority();
			case Site:
				return new SiteID();
			case Status:
				return new StatusID();
			case Talkgroup:
				return new TalkgroupID();
			default:
				throw new IllegalArgumentException( "Unrecognized Alias ID type: " + type );
		}
	}
}
