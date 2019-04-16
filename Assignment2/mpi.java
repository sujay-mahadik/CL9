import mpi.MPI;
import mpi.MPIException;

public class mpi {

	public static void main(String[] args) throws MPIException {
		MPI.Init(args);

		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		// System.out.println(rank + " " + size);

		if (rank == 1) {
			int[] data = new int[1];
			data[0] = 100;
			MPI.COMM_WORLD.Send(data, 0, 1, MPI.INT, 0, MPI.ANY_SOURCE);

			MPI.COMM_WORLD.Recv(data, 0, 1, MPI.INT, 0, MPI.ANY_SOURCE);
			System.out.println("Reply to process " + rank + ": " + data[0]);

		} else {
			int[] data = new int[1];
			MPI.COMM_WORLD.Recv(data, 0, 1, MPI.INT, 1, MPI.ANY_SOURCE);
			System.out.println("Received by process " + rank + ": " + data[0]);

			data[0] = data[0] * 2;
			MPI.COMM_WORLD.Send(data, 0, 1, MPI.INT, 1, MPI.ANY_SOURCE);

		}
	}

}
