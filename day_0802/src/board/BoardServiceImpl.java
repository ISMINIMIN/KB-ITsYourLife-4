package board;

import java.sql.SQLException;
import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.dao.DuplicatedIdException;
import board.dao.RecordNotFoundException;
import board.dto.BoardDto;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public boolean add(BoardDto dto) throws BoardException {
		try {
			boardDao.add(dto);
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		} catch (DuplicatedIdException e) {}
		
		return true;
	}
	
	@Override
	public List<BoardDto> list() throws BoardException {
		List<BoardDto> list = null;
		try {
			list = boardDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public BoardDto read(int no) throws BoardException, RecordNotFoundException {
		BoardDto dto = null;
		try {
			dto = boardDao.findById(no);
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		} catch (RecordNotFoundException e) {
			System.out.println("정보를 찾을 수 없습니다.");
		}
		
		return dto;
	}

	@Override
	public boolean update(BoardDto dto) throws BoardException {
		try {
			boardDao.update(dto);
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		} catch (RecordNotFoundException e) {
			System.out.println("정보를 찾을 수 없습니다.");
		}
		
		return true;
	}

	@Override
	public boolean delete(int no) throws BoardException, RecordNotFoundException {
		boolean flag = false;
		
		try {
			boardDao.delete(no);
			flag = true;
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		} catch (RecordNotFoundException e) {
			System.out.println("정보를 찾을 수 없습니다!!");
		}
		
		return flag;
	}

	@Override
	public int count() throws BoardException {
		int count = 0;
		try {
			count = boardDao.count();
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		}
		return count;
	}

}
