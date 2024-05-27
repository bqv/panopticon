package ltd.ucode.panopticon.data.datasources.implementation.client

import ltd.ucode.panopticon.core.data.Failure
import ltd.ucode.panopticon.core.data.Success
import ltd.ucode.panopticon.data.models.NetworkPicture
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test

@ExperimentalCoroutinesApi
class PicSumClientTest {

    private val service: PicSumService = mockk()
    private val client: PicSumClient = PicSumClient(service)

    @Test
    fun `fetch service with response case`() = runBlockingTest {
        //Given
        coEvery { service.fetchList() } returns emptyList()
        //When
        val response = client.fetchList()
        //Then
        val output = (response as Success<List<NetworkPicture>>).out
        assertThat(output, IsEqual(emptyList()))
    }

    @Test
    fun `fetch service with exception`() = runBlockingTest {
        //Given
        val message = "fake_message"
        coEvery { service.fetchList() } throws Throwable(message)
        //When
        val response = client.fetchList()
        //Then
        val error = (response as Failure).exception
        assertThat(error, IsEqual(ServiceError(message)))
    }
}
