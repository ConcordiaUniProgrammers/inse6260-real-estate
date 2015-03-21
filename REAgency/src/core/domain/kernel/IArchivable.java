package core.domain.kernel;

import java.util.Date;

public interface IArchivable {
	boolean getIsArchived();
	void setIsArchived(boolean isArchived);
    Date getDateOfArchive();
    void setDateOfArchive(Date dateOfArchive); 
}
