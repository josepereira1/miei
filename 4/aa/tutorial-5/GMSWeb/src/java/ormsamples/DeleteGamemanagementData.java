/**
 * Licensee: josepereira(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteGamemanagementData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = pt.uminho.di.aa.GamemanagementPersistentManager.instance().getSession().beginTransaction();
		try {
			pt.uminho.di.aa.User lptuminhodiaaUser = pt.uminho.di.aa.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			pt.uminho.di.aa.UserDAO.delete(lptuminhodiaaUser);
			pt.uminho.di.aa.Game lptuminhodiaaGame = pt.uminho.di.aa.GameDAO.loadGameByQuery(null, null);
			// Delete the persistent object
			pt.uminho.di.aa.GameDAO.delete(lptuminhodiaaGame);
			pt.uminho.di.aa.Platform lptuminhodiaaPlatform = pt.uminho.di.aa.PlatformDAO.loadPlatformByQuery(null, null);
			// Delete the persistent object
			pt.uminho.di.aa.PlatformDAO.delete(lptuminhodiaaPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteGamemanagementData deleteGamemanagementData = new DeleteGamemanagementData();
			try {
				deleteGamemanagementData.deleteTestData();
			}
			finally {
				pt.uminho.di.aa.GamemanagementPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
